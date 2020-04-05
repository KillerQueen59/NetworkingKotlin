package com.example.kotlinnetworking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val dataSource = NetworkProvider.providesHttpAdapter().create(HomeDataSource::class.java)
        dataSource.discoverMovie().enqueue(object :  Callback<HomeResponse> {
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                progressBar.visibility = View.GONE
                val result = response.body()?.result //
                val recyclerView = findViewById<RecyclerView>(R.id.rv_movie)
                recyclerView.addItemDecoration(DividerItemDecoration(this@HomeActivity,
                    DividerItemDecoration.VERTICAL))

            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {

            }


        })

    }
}
