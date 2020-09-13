package com.example.android.devbyteviewer.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Main entry point for network access. Call like `Network.devbytes.getPlaylist()`
 */
object Network {

    private const val BASE_URL = "https://devbytes.udacity.com/"
    /**
     * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
     * full Kotlin compatibility.
     */
    private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    val devbytes: DevByteService = retrofit.create(DevByteService::class.java)
}