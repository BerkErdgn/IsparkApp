package com.berkerdgn.isparkapp.presentation.ispark_save

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.berkerdgn.isparkapp.data.remote.dto.room_dto.SavedIsparkDto
import com.berkerdgn.isparkapp.domain.repository.IsparkRepository
import com.berkerdgn.isparkapp.domain.use_case.get_ispark_detail.GetIsparkDetailUseCase
import com.berkerdgn.isparkapp.domain.use_case.get_saved_ispark.GetIsparkSavedUseCase
import com.berkerdgn.isparkapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class IsparkSaveViewModel @Inject constructor(
    private val getIsparkSavedUseCase: GetIsparkSavedUseCase,
    private val repository: IsparkRepository
) : ViewModel(){

    private val _state = mutableStateOf<IsparkSaveState>(IsparkSaveState())
    val state : State<IsparkSaveState> = _state

    init {
        getSavedIsparks()
    }

    private fun getSavedIsparks(){
        getIsparkSavedUseCase.exexuteGetIsparkSaved().onEach {
            when(it){
                is Resource.Success ->{
                    _state.value = IsparkSaveState(isparks = it.data ?: listOf())
                }
                is Resource.Loading ->{
                    _state.value = IsparkSaveState(isLoading = true)
                }
                is Resource.Error ->{
                    _state.value = IsparkSaveState(error = it.message ?: "Error in viewModel")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun deleteIspark(ispark : SavedIsparkDto){ viewModelScope.launch {
        repository.deleteIsparks(isparks = ispark)
        }
    }


    fun insertIspark(ispark : SavedIsparkDto){viewModelScope.launch {
        repository.insertIsparks(isparks = ispark)
        }
    }

    fun saveIspark (parkID: Int, parkName: String){
        val saveIspark = SavedIsparkDto(parkID = parkID, parkName = parkName)
        insertIspark(saveIspark)
    }






}