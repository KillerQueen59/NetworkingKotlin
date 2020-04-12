package com.example.kotlinnetworking.di.module

import com.example.kotlinnetworking.data.HomeDataSource
import com.example.kotlinnetworking.presentation.HomeActivity
import com.example.kotlinnetworking.presentation.HomePresenter
import com.example.kotlinnetworking.presentation.HomeView
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class HomeModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun providesHomeDataSource(retrofit: Retrofit): HomeDataSource = retrofit.create(HomeDataSource::class.java)

        @JvmStatic
        @Provides
        fun providesHomePresenter(
            view : HomeView,
            dataSource : HomeDataSource
        ): HomePresenter = HomePresenter(view,dataSource)
    }

    @Binds
    abstract fun bindHomeView(activity: HomeActivity) : HomeView
}