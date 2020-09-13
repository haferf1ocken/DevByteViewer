package com.example.android.devbyteviewer.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface VideoDao {
    @Query("SELECT * FROM databasevideo")
    fun getVideos(): LiveData<List<DataBaseVideo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg videos: DataBaseVideo)
}