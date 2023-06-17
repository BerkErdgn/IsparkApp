package com.berkerdgn.isparkapp.domain.use_case.get_saved_ispark

import com.berkerdgn.isparkapp.data.remote.dto.room_dto.SavedIsparkDto
import com.berkerdgn.isparkapp.domain.repository.IsparkRepository
import com.berkerdgn.isparkapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import javax.inject.Inject

class GetIsparkSavedUseCase @Inject constructor(
    private val repository: IsparkRepository
){


    fun exexuteGetIsparkSaved(): Flow<Resource<List<SavedIsparkDto>>> = flow{
        try {
            emit(Resource.Loading())
            repository.getSavedIsparks().collect{
                if (it.isNotEmpty()){
                    emit(Resource.Success(it))
                }else{
                    emit(Resource.Error(message = "Error"))
                    }
            }

        }catch (e:Exception){
            emit(Resource.Error(message = "Error"))
        }


    }



}