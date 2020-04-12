package com.example.kotlinnetworking.presentation

import com.example.kotlinnetworking.data.Result

interface HomeView{//contract base
    fun onShowLoading()
    fun onHideLoading()
    fun onResponse(result : List<Result>)
    fun onFailure(error: Throwable)
}