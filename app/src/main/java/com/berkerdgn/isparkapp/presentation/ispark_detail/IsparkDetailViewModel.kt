package com.berkerdgn.isparkapp.presentation.ispark_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkerdgn.isparkapp.domain.use_case.get_ispark_detail.GetIsparkDetailUseCase
import com.berkerdgn.isparkapp.util.Constant.PARK_ID
import com.berkerdgn.isparkapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class IsparkDetailViewModel @Inject constructor(
    private val getIsparkDetailUseCase: GetIsparkDetailUseCase,
    private val stateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf<IsparkDetailViewState>(IsparkDetailViewState())
    val state : State<IsparkDetailViewState> = _state

    init {
        stateHandle.get<String>(PARK_ID)?.let {
            getIsparkDetails(parkID = it)
        }
    }

    private fun getIsparkDetails( parkID : String){
        getIsparkDetailUseCase.executeGetIsparkDetails(parkID).onEach {
            when(it){
                is Resource.Success ->{
                    _state.value = IsparkDetailViewState(isparkDetail = it.data ?: arrayListOf() )
                }
                is Resource.Loading -> {
                    _state.value = IsparkDetailViewState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = IsparkDetailViewState(error = it.message ?: "Error in viewModel")
                }
            }
        }.launchIn(viewModelScope)
    }



}