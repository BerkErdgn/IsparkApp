package com.berkerdgn.isparkapp.data.roomdb

import androidx.room.*
import com.berkerdgn.isparkapp.data.remote.dto.room_dto.SavedIsparkDto
import com.berkerdgn.isparkapp.util.Resource
import kotlinx.coroutines.flow.Flow


@Dao
interface IsparksDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIsparks(isparks:SavedIsparkDto)

    @Delete
    suspend fun deleteIsparks(isparks: SavedIsparkDto)

    @Query(value = "SELECT * FROM savedIspark")
    fun isparksFlow(): Flow<List<SavedIsparkDto>>

}