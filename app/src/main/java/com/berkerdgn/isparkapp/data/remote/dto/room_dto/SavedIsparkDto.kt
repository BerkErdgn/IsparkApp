package com.berkerdgn.isparkapp.data.remote.dto.room_dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "savedIspark")
data class SavedIsparkDto(
    @ColumnInfo(name = "parkID" )
    val parkID: Int,
    @ColumnInfo(name = "parkName" )
    val parkName: String,
    @PrimaryKey(autoGenerate = true)
    var id:Int ? = null
)
