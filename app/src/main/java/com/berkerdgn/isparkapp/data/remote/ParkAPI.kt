package com.berkerdgn.isparkapp.data.remote

import com.berkerdgn.isparkapp.data.remote.dto.IsparkDetailDto
import com.berkerdgn.isparkapp.data.remote.dto.IsparkDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ParkAPI {

    @GET("Park")
    suspend fun getIsparks(): IsparkDto


    @GET("ParkDetay")
    suspend fun getIsparkDetail(
        @Query("id") parkID: String
    ) : IsparkDetailDto


}