package com.redveloper.sportapp.core.di

import androidx.room.Room
import com.redveloper.sportapp.core.data.Repository
import com.redveloper.sportapp.core.data.source.local.LocalDataSource
import com.redveloper.sportapp.core.data.source.local.room.AppDatabase
import com.redveloper.sportapp.core.data.source.remote.RemoteDataSource
import com.redveloper.sportapp.core.data.source.remote.network.ApiService
import com.redveloper.sportapp.core.domain.repository.RepositoryImpl
import com.redveloper.sportapp.core.utils.AppExecutors
import com.redveloper.sportapp.core.utils.Constanta
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<AppDatabase>().ClassementDao() }
    factory { get<AppDatabase>().MatchDao() }
    factory { get<AppDatabase>().TeamDao() }
    single {
        val passphrese: ByteArray = SQLiteDatabase.getBytes("renaldy".toCharArray())
        val factory = SupportFactory(passphrese)
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "content.db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostname = "www.thesportsdb.com"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/FEzVOUp4dF3gI0ZVPRJhFbSJVXR+uQmMH65xhs1glH4=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constanta.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get(), get(), get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single <RepositoryImpl>{ Repository(get(), get(), get()) }
}