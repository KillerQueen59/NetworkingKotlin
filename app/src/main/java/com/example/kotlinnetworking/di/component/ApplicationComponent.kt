package com.example.kotlinnetworking.com.example.kotlinnetworking.di.component

import com.example.kotlinnetworking.BelajarApp
import dagger.android.support.AndroidSupportInjectionModule
import com.example.kotlinnetworking.di.builder.ActivityBuilder
import com.example.kotlinnetworking.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    ActivityBuilder::class

])
interface ApplicationComponent : AndroidInjector<BelajarApp>