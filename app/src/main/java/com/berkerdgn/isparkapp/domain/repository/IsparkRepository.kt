package com.berkerdgn.isparkapp.domain.repository

import com.berkerdgn.isparkapp.data.remote.dto.IsparkDetailDto
import com.berkerdgn.isparkapp.data.remote.dto.IsparkDto
import com.berkerdgn.isparkapp.data.remote.dto.room_dto.SavedIsparkDto
import com.berkerdgn.isparkapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface IsparkRepository {

    suspend fun getIsparks () : IsparkDto

    suspend fun getIsparkDetail (parkID:String) : IsparkDetailDto

    suspend fun insertIsparks(isparks:SavedIsparkDto)


    suspend fun  deleteIsparks(isparks: SavedIsparkDto)

     fun getSavedIsparks(): Flow<List<SavedIsparkDto>>

}