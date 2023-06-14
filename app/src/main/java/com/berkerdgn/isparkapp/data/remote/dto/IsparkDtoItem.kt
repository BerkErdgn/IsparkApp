package com.berkerdgn.isparkapp.data.remote.dto

data class IsparkDtoItem(
    val capacity: Int,
    val district: String,
    val emptyCapacity: Int,
    val freeTime: Int,
    val isOpen: Int,
    val lat: String,
    val lng: String,
    val parkID: Int,
    val parkName: String,
    val parkType: String,
    val workHours: String
)