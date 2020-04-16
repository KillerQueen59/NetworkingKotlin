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
    /*Stream yang digunakan untuk melakukan proses threading, yang
    dimana output dari proses tersebut hanya terdapat 1 thread saja sehingga
    bisa dikatakan lebih ringan dan tidak membebani pemakaian memori yang
    cukup besar untuk melakukan proses thread*/
}