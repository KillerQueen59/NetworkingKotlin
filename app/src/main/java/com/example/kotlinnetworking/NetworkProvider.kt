package com.example.kotlinnetworking

import com.example.kotlinnetworking.BuildConfig.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.logging.Level

object NetworkProvider{

    fun providesHttpAdapter(): Retrofit {
        return Retrofit.Builder().apply {
            client(providesHtppClient())
            baseUrl(BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

    private fun providesHtppClient(): OkHttpClient{
        return OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true) // Untuk mendapatkan hasil dari json yang dituju
            addInterceptor(providesHttpLoggingInterceptor()) // memanggil fungsi providesHttpLoggingInterceptor
        }.build()
    }

    private fun providesHttpLoggingInterceptor():HttpLoggingInterceptor{ //mendapatkan log sesuai kebutuhan
        return HttpLoggingInterceptor().apply {
            level = when (BuildConfig.DEBUG){
                true -> HttpLoggingInterceptor.Level.BODY
                false -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }
}