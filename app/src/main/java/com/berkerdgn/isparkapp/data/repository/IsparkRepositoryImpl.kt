package com.berkerdgn.isparkapp.data.repository

import com.berkerdgn.isparkapp.data.remote.ParkAPI
import com.berkerdgn.isparkapp.data.remote.dto.IsparkDetailDto
import com.berkerdgn.isparkapp.data.remote.dto.IsparkDto
import com.berkerdgn.isparkapp.domain.repository.IsparkRepository
import javax.inject.Inject


class IsparkRepositoryImpl @Inject constructor(
    private val parkAPI: ParkAPI
) : IsparkRepository {
    override suspend fun getIsparks(): IsparkDto {
        return parkAPI.getIsparks()
    }

    override suspend fun getIsparkDetail(parkID: String): IsparkDetailDto {
        return  parkAPI.getIsparkDetail(parkID = parkID)
    }
}