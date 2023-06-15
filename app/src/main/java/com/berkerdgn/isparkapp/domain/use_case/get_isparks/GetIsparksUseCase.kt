package com.berkerdgn.isparkapp.domain.use_case.get_isparks

import com.berkerdgn.isparkapp.data.remote.dto.IsparkDto
import com.berkerdgn.isparkapp.domain.repository.IsparkRepository
import com.berkerdgn.isparkapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class GetIsparksUseCase @Inject constructor(
    private val repository: IsparkRepository
) {

    fun executeGetIsparks() : Flow<Resource<IsparkDto>> = flow{
        try {
            emit(Resource.Loading())
            val isparkList = repository.getIsparks()
            if (isparkList.isNotEmpty()){
                emit(Resource.Success(isparkList))
            }else{
                emit(Resource.Error(message = "Error"))
            }

        }catch (e: Exception){
            emit(Resource.Error(message = "Main Error"))
        }
    }


}