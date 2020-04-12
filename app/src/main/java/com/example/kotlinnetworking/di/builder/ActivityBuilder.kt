package com.example.kotlinnetworking.di.builder

import com.example.kotlinnetworking.com.example.kotlinnetworking.di.scope.Presentation
import com.example.kotlinnetworking.di.module.HomeModule
import com.example.kotlinnetworking.presentation.HomeActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @Presentation
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeActivity(): HomeActivity
}