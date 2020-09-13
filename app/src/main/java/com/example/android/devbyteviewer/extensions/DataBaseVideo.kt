package com.example.android.devbyteviewer.extensions

import com.example.android.devbyteviewer.database.DataBaseVideo
import com.example.android.devbyteviewer.domain.Video

fun List<DataBaseVideo>.asDomainModel(): List<Video> {
    return map {
        Video (
                url = it.url,
                updated = it.updated,
                title = it.title,
                description = it.description,
                thumbnail = it.thumbnail
        )
    }
}