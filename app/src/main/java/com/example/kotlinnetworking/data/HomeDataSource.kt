package com.example.kotlinnetworking.data

import com.example.kotlinnetworking.BuildConfig
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface HomeDataSource {

    @GET("/3/discover/movie")
    fun discoverMovie(
        @Query("api_key")
        apiKey:String = BuildConfig.API_KEY
    ): Single<HomeResponse> // mengganti fungsi retrofit dengan rxJava
}