package com.example.kotlinnetworking.data

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("results")
    val result: List<Result>
)

data class Result(
    @SerializedName("title")
    val title: String,

    @SerializedName("overview")
    val desc: String,

    @SerializedName("poster_path")
    var poster: String
)