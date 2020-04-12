package com.example.kotlinnetworking.presentation

import com.example.kotlinnetworking.NetworkProvider
import com.example.kotlinnetworking.data.HomeDataSource
import com.example.kotlinnetworking.data.HomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter (private val view: HomeView){
    fun discoverMovie(){
        view.onShowLoading()

        val dataSource = NetworkProvider.providesHttpAdapter().create(HomeDataSource::class.java)
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