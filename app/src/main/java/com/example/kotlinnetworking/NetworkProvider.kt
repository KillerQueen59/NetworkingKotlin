package com.example.kotlinnetworking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.logging.Level

object NetworkProvider{

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