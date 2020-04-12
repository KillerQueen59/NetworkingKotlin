package com.example.kotlinnetworking


import com.example.kotlinnetworking.com.example.kotlinnetworking.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class BelajarApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.create().apply { inject(this@BelajarApp) }
    }
}

