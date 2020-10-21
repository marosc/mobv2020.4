package com.example.viewmodel.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodel.R
import com.example.viewmodel.data.db.model.MarsItem

class MarsAdapter : RecyclerView.Adapter<MarsAdapter.ViewHolder>() {

    var data = listOf<MarsItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(item: MarsItem) {
            Log.d("udajeVRiadku", "su $item")
            //Picasso.get().load(item.img_src).into(itemView as ImageView)
            (itemView as TextView).text = "${item.price} eur"
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.text_item, parent, false)

                return ViewHolder(view)
            }
        }
    }
}