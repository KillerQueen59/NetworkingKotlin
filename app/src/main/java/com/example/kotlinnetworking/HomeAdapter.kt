package com.example.kotlinnetworking

import android.view.View
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class HomeAdapter (private val result: List<Result>) {


    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(result : Result){
            with(itemView){
                val title = findViewById<TextView>(R.id.titleMovie)
                title.text = result.title

                val desc = findViewById<TextView>(R.id.descMovie)


                val image = findViewById<ImageView>(R.id.imageMovie)

            }
        }
    }
}
