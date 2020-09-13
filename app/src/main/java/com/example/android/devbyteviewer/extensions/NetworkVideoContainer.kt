package com.example.android.devbyteviewer.extensions

import com.example.android.devbyteviewer.database.DataBaseVideo
import com.example.android.devbyteviewer.domain.Video
import com.example.android.devbyteviewer.network.NetworkVideoContainer

/**
 * Convert Network results to database objects
 */
fun NetworkVideoContainer.asDomainModel(): List<Video> {
    return videos.map {
        Video(
                title = it.title,
                description = it.description,
                url = it.url,
                updated = it.updated,
                thumbnail = it.thumbnail)
    }
}

fun NetworkVideoContainer.asDatabaseModel(): Array<DataBaseVideo> {
    return videos.map {
        DataBaseVideo (
                title = it.title,
                description = it.description,
                url = it.url,
                updated = it.updated,
                thumbnail = it.thumbnail
        )
    }.toTypedArray()
}