package com.example.android.devbyteviewer.repository

import timber.log.Timber
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.devbyteviewer.database.VideosDatabase
import com.example.android.devbyteviewer.domain.Video
import com.example.android.devbyteviewer.extensions.asDatabaseModel
import com.example.android.devbyteviewer.extensions.asDomainModel
import com.example.android.devbyteviewer.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class VideosRepository(private val database: VideosDatabase) {

    val videos: LiveData<List<Video>> = Transformations.map(database.videoDao.getVideos()) {
        it.asDomainModel()
    }

    suspend fun refreshVideos() = withContext(Dispatchers.IO) {
        val playlist = Network.devbytes.getPlaylistAsync()
        database.videoDao.insertAll(*playlist.asDatabaseModel())
    }
}
