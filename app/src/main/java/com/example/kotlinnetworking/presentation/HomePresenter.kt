package com.example.kotlinnetworking.presentation

import com.example.kotlinnetworking.di.module.NetworkModule
import com.example.kotlinnetworking.data.HomeDataSource
import com.example.kotlinnetworking.data.HomeResponse
import dagger.Module
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomePresenter (
    private val view: HomeView,
    private val dataSource: HomeDataSource
){
    fun discoverMovie(){
        view.onShowLoading()


        dataSource.discoverMovie().enqueue(object : Callback<HomeResponse>{
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                view.onHideLoading()
                view.onResponse(response.body()?.result ?: emptyList())
            }
            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                view.onHideLoading()
                view.onFailure(t)
            }

        })
    }
}