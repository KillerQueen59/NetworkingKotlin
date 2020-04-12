package com.example.kotlinnetworking.di.module

import com.example.kotlinnetworking.BuildConfig
import com.example.kotlinnetworking.BuildConfig.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule{

    @Provides
    @Singleton
    fun providesHttpAdapter(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().apply {
            client(client)
            baseUrl(BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

    @Provides
    @Singleton
     fun providesHtppClient(interceptor: HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true) // Untuk mendapatkan hasil dari json yang dituju
            addInterceptor(interceptor) // memanggil fungsi providesHttpLoggingInterceptor
        }.build()
    }

    @Provides
    @Singleton
     fun providesHttpLoggingInterceptor():HttpLoggingInterceptor{ //mendapatkan log sesuai kebutuhan
        return HttpLoggingInterceptor().apply {
            level = when (BuildConfig.DEBUG){
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}