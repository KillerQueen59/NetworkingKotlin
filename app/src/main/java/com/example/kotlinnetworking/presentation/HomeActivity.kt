package com.example.kotlinnetworking.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinnetworking.R
import com.example.kotlinnetworking.data.Result
import dagger.Module
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() ,  HomeView {

    @Inject
    lateinit var presenter : HomePresenter // lateinit buat non null type dengan dependency injection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rv_movie.setHasFixedSize(true)
        rv_movie.layoutManager = LinearLayoutManager(this)

        presenter.discoverMovie()
    }
    override fun onShowLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun onHideLoading() {
        progressBar.visibility = View.GONE
        rv_movie.visibility = View.VISIBLE
    }

    override fun onResponse(result: List<Result>) {
        rv_movie.addItemDecoration(DividerItemDecoration(this@HomeActivity,DividerItemDecoration.VERTICAL))
        rv_movie.adapter = HomeAdapter(result)
    }

    override fun onFailure(error: Throwable) {
        Log.d("ojan","error")
    }

}
