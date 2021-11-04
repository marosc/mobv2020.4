package com.example.viewmodel.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.viewmodel.data.db.model.MarsItem
import com.example.viewmodel.databinding.MarsItemBinding
import com.squareup.picasso.Picasso

class MarsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items: MutableList<MarsItem> = mutableListOf()

    public fun updateData(newItems: List<MarsItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

//    var items: List<MarsItem> by Delegates.observable(emptyList()) { prop, old, new ->
//        autoNotify(old, new) { o, n -> o.id.compareTo(n.id) == 0 }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MarsViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MarsViewHolder).bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MarsViewHolder(private var binding: MarsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MarsItem) {
            binding.property = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): RecyclerView.ViewHolder {
                val view = MarsItemBinding.inflate(LayoutInflater.from(parent.context))
                return MarsViewHolder(view)
            }
        }
    }

}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        Log.d("obrazok", "je $it")

        Picasso.get()
            .load(it)
            .resize(50, 50)
            .centerCrop()

            .into(imgView)
    }
}
