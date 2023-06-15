package com.berkerdgn.isparkapp.presentation.ispark_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berkerdgn.isparkapp.data.remote.dto.IsparkDtoItem
import com.berkerdgn.isparkapp.domain.use_case.get_isparks.GetIsparksUseCase
import com.berkerdgn.isparkapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class IsparksViewModel @Inject constructor(
    private val getIsparksUseCase: GetIsparksUseCase
): ViewModel(){

    private val _state = mutableStateOf<IsparkViewState>(IsparkViewState())
    val state : State<IsparkViewState> = _state

    private var job : Job? = null


    init {
        getIsparks()
    }


    private fun getIsparks(){

        job?.cancel()

        job = getIsparksUseCase.executeGetIsparks().onEach {
            when(it){
                is Resource.Success ->{
                    _state.value = IsparkViewState(isparks = it.data ?: ArrayList<IsparkDtoItem>())
                }

                is Resource.Loading ->{
                    _state.value = IsparkViewState(isLoading = true)
                }

                is Resource.Error ->{
                    _state.value = IsparkViewState(error = it.message ?: "Error (ViewModel)")
                }
            }

        }.launchIn(viewModelScope)

    }


}
