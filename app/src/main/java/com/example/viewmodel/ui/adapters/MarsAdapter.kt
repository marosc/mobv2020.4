package com.example.viewmodel.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodel.data.db.model.MarsItem
import com.example.viewmodel.databinding.ImageItemBinding
import com.example.viewmodel.ui.autoNotify
import kotlin.properties.Delegates

class MarsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<MarsItem> by Delegates.observable(emptyList()) { prop, old, new ->
        autoNotify(old, new) { o, n -> o.id.compareTo(n.id) == 0 }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent
        )
    }

    class ViewHolder(private var binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(item: MarsItem) {
            Log.d("riadok", "je $item")
            binding.property = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view = ImageItemBinding.inflate(LayoutInflater.from(parent.context))

                return ViewHolder(
                    view
                )
            }
        }
    }

}