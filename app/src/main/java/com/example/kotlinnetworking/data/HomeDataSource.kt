package com.example.kotlinnetworking.data

import com.example.kotlinnetworking.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query


interface HomeDataSource {

    @GET("/3/discover/movie")
    fun discoverMovie(
        @Query("api_key")
        apiKey:String = BuildConfig.API_KEY
    ): retrofit2.Call<HomeResponse>
}