package com.example.viewmodel.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import java.util.*

fun <T> RecyclerView.Adapter<*>.autoNotify(
    oldList: List<T>,
    newList: List<T>,
    compare: (T, T) -> Boolean
) {
    val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return compare(oldList[oldItemPosition], newList[newItemPosition])
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return Objects.equals(oldList[oldItemPosition], newList[newItemPosition])
        }

        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            return super.getChangePayload(oldItemPosition, newItemPosition)
        }

        override fun getOldListSize() = oldList.size
        override fun getNewListSize() = newList.size
    })
    diff.dispatchUpdatesTo(this)
}