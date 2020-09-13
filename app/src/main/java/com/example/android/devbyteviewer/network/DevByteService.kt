package com.example.android.devbyteviewer.network

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

// Since we only have one service, this can all go in one file.
// If you add more services, split this to multiple files and make sure to share the retrofit
// object between services.
/**
 * A retrofit service to fetch a devbyte playlist.
 */
interface DevByteService {
    @GET("devbytes.json")
    suspend fun getPlaylistAsync(): NetworkVideoContainer
}
