package com.example.android.devbyteviewer.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.devbyteviewer.domain.Video

@Entity
data class DataBaseVideo(
        @PrimaryKey
        val url: String,
        val updated: String,
        val title: String,
        val description: String,
        val thumbnail: String)