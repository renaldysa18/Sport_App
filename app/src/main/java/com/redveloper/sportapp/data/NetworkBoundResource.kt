package com.redveloper.sportapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.redveloper.sportapp.data.source.remote.ApiResponse
import com.redveloper.sportapp.data.source.remote.StatusResponse
import com.redveloper.sportapp.utils.AppExecutors
import com.redveloper.sportapp.vo.Resource

abstract class NetworkBoundResource <ResultType, RequestType>(private val mExecutors: AppExecutors){

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.Loading(null)

        @Suppress("LeakingThis")
        val dbSource = loadFromDB()

        result.addSource(dbSource) {data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)){
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) {newData ->
                    result.value = Resource.Succes(newData)
                }
            }
        }
    }

    protected open fun onFetchFailed(){}

    protected abstract fun loadFromDB() : LiveData<ResultType>

    protected abstract fun shouldFetch(data : ResultType?) : Boolean

    protected abstract fun createCall() : LiveData<ApiResponse<RequestType>>

    protected abstract fun saveCallResult(data: RequestType)

    protected fun fetchFromNetwork(dbSource : LiveData<ResultType>){
        val apiResponse = createCall()
        result.addSource(dbSource){newData ->
            result.value = Resource.Loading(newData)
        }

        result.addSource(apiResponse){response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)
            when(response.status){
                StatusResponse.SUCCESS -> {
                    mExecutors.diskIO().execute {
                        response.body?.let { saveCallResult(it) }
                        mExecutors.mainThread().execute {
                            result.addSource(loadFromDB()){newData ->
                                result.value = Resource.Succes(newData)
                            }
                        }
                    }
                }
                StatusResponse.EMPTY -> {
                    mExecutors.mainThread().execute {
                        result.addSource(loadFromDB()){newData ->
                            result.value = Resource.Succes(newData)
                        }
                    }
                }
                StatusResponse.ERROR -> {
                    onFetchFailed()
                    result.addSource(dbSource){newData ->
                        result.value = Resource.Error(newData, response.message)
                    }
                }
            }
        }
    }

    fun asLiveData() : LiveData<Resource<ResultType>> = result
}