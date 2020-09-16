package com.redveloper.sportapp.vo

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Succes<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(data : T? = null, message: String?) : Resource<T>(data, message)
}