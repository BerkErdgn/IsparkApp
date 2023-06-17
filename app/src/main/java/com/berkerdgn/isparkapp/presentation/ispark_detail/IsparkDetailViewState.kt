package com.berkerdgn.isparkapp.presentation.ispark_detail

import com.berkerdgn.isparkapp.data.remote.dto.IsparkDetailDtoItem

data class IsparkDetailViewState (
    val isLoading : Boolean = false,
    val isparkDetail : ArrayList<IsparkDetailDtoItem> = ArrayList(),
    val error : String = ""
)