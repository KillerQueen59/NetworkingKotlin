package com.example.kotlinnetworking.presentation

import com.example.kotlinnetworking.di.module.NetworkModule
import com.example.kotlinnetworking.data.HomeDataSource
import com.example.kotlinnetworking.data.HomeResponse
import dagger.Module
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomePresenter (
    private val view: HomeView,
    private val dataSource: HomeDataSource
){

    private val disposable:CompositeDisposable = CompositeDisposable()

    fun discoverMovie(){
        view.onShowLoading()
        dataSource.discoverMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({response ->
                view.onHideLoading()
                view.onResponse(response.result)
            },{error ->
                view.onHideLoading()
                view.onFailure(error)
            }).addTo(disposable)




    }
    fun onDetach(){
        disposable.clear()
    }
}