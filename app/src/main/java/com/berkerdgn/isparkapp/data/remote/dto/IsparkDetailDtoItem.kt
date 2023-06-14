package com.berkerdgn.isparkapp.data.remote.dto

data class IsparkDetailDtoItem(
    val address: String,
    val areaPolygon: String,
    val capacity: Int,
    val district: String,
    val emptyCapacity: Int,
    val freeTime: Int,
    val lat: String,
    val lng: String,
    val locationName: String,
    val monthlyFee: Double,
    val parkID: Int,
    val parkName: String,
    val parkType: String,
    val tariff: String,
    val updateDate: String,
    val workHours: String
)