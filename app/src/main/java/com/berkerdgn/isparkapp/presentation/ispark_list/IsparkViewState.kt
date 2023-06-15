package com.berkerdgn.isparkapp.presentation.ispark_list

import com.berkerdgn.isparkapp.data.remote.dto.IsparkDto
import com.berkerdgn.isparkapp.data.remote.dto.IsparkDtoItem

data class IsparkViewState (
    val isLoading : Boolean = false,
    val isparks : ArrayList<IsparkDtoItem> = ArrayList<IsparkDtoItem>(),
    val error : String = "",
        )