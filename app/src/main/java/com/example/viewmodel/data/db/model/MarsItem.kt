package com.example.viewmodel.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
data class MarsItem(
    val price: Long,
    @PrimaryKey val id: String,
    val type: String,
    val img_src: String
)