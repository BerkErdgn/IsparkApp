package com.berkerdgn.isparkapp.domain.repository

import com.berkerdgn.isparkapp.data.remote.dto.IsparkDetailDto
import com.berkerdgn.isparkapp.data.remote.dto.IsparkDto

interface IsparkRepository {

    suspend fun getIsparks () : IsparkDto

    suspend fun getIsparkDetail (parkID:String) : IsparkDetailDto
}