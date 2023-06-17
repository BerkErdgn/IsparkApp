package com.berkerdgn.isparkapp.presentation.ispark_save

import com.berkerdgn.isparkapp.data.remote.dto.room_dto.SavedIsparkDto


data class IsparkSaveState (
    val isLoading : Boolean = false,
    val isparks : List<SavedIsparkDto> = listOf(),
    val error : String = "",
        )