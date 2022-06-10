package com.example.challange8.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database( entities = [DataUser::class],
    version = 1,
    exportSchema = false)

abstract class RoomDatabaseStore : RoomDatabase() {
    abstract fun dataUserDao(): DataUserDao
//    abstract fun favoriteDao(): FavoriteDao
}