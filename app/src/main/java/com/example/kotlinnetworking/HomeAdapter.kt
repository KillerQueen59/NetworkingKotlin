package com.example.kotlinnetworking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlinnetworking.HomeAdapter.HomeViewHolder
import org.w3c.dom.Text

class HomeAdapter (private val results: List<Result>) : RecyclerView.Adapter<HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return results.count()
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(results[holder.adapterPosition])
    }


    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(result : Result){
            with(itemView){
                val title = findViewById<TextView>(R.id.titleMovie)
                title.text = result.title

                val desc = findViewById<TextView>(R.id.descMovie)
                desc.text = result.desc

                val image = findViewById<ImageView>(R.id.imageMovie)
                Glide.with(context)
                    .load("https://image.tmdb.org/t/p/original/" + result.poster )
                    .apply(RequestOptions.overrideOf(200,250))
                    .into(image)

            }
        }
    }
}
