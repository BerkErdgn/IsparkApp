package com.berkerdgn.isparkapp.data.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.berkerdgn.isparkapp.data.remote.dto.room_dto.SavedIsparkDto


@Database(entities = [SavedIsparkDto::class], version = 1)
abstract class IsparksDatabase : RoomDatabase() {

    abstract fun isparksDao(): IsparksDao
}