package com.example.android.devbyteviewer.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataBaseVideo::class], version = 1)
abstract class VideosDatabase: RoomDatabase() {
    abstract val videoDao: VideoDao
    companion object {
        @Volatile
        private lateinit var INSTANCE: VideosDatabase

        fun getDatabase(context: Context) : VideosDatabase {
            synchronized(VideosDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            VideosDatabase::class.java,
                            "videos").build()
                }
            }
            return INSTANCE
        }
    }
}