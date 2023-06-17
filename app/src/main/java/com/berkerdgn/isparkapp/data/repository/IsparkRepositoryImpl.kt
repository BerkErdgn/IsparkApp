package com.berkerdgn.isparkapp.data.repository

import com.berkerdgn.isparkapp.data.remote.ParkAPI
import com.berkerdgn.isparkapp.data.remote.dto.IsparkDetailDto
import com.berkerdgn.isparkapp.data.remote.dto.IsparkDto
import com.berkerdgn.isparkapp.data.remote.dto.room_dto.SavedIsparkDto
import com.berkerdgn.isparkapp.data.roomdb.IsparksDao
import com.berkerdgn.isparkapp.domain.repository.IsparkRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class IsparkRepositoryImpl @Inject constructor(
    private val isparksDao : IsparksDao,
    private val parkAPI: ParkAPI
) : IsparkRepository {
    override suspend fun getIsparks(): IsparkDto {
        return parkAPI.getIsparks()
    }

    override suspend fun getIsparkDetail(parkID: String): IsparkDetailDto {
        return  parkAPI.getIsparkDetail(parkID = parkID)
    }


    //for Room

    override suspend fun insertIsparks(isparks: SavedIsparkDto) {
        isparksDao.insertIsparks(isparks = isparks)
    }

    override suspend fun deleteIsparks(isparks: SavedIsparkDto) {
        isparksDao.deleteIsparks(isparks = isparks)
    }

    override  fun getSavedIsparks(): Flow<List<SavedIsparkDto>> {
        return isparksDao.isparksFlow()
    }
}