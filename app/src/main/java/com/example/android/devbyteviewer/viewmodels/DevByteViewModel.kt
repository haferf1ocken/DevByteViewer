package com.example.android.devbyteviewer.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.example.android.devbyteviewer.database.VideosDatabase
import com.example.android.devbyteviewer.repository.VideosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.lang.Exception


/**
 * DevByteViewModel designed to store and manage UI-related data in a lifecycle conscious way. This
 * allows data to survive configuration changes such as screen rotations. In addition, background
 * work such as fetching network results can continue through configuration changes and deliver
 * results after the new Fragment or Activity is available.
 *
 * @param application The application that this viewmodel is attached to, it's safe to hold a
 * reference to applications across rotation since Application is never recreated during actiivty
 * or fragment lifecycle events.
 */
class DevByteViewModel(application: Application) : AndroidViewModel(application) {

    private val database = VideosDatabase.getDatabase(application)
    private val videosRepository = VideosRepository(database)

    init {
        viewModelScope.launch {
            try {
                videosRepository.refreshVideos()
            } catch (e: Exception) {
                Timber.d("No internet")
            }
        }
    }

    val playlist = videosRepository.videos

}
