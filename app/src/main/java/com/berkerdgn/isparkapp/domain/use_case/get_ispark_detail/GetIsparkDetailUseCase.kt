package com.berkerdgn.isparkapp.domain.use_case.get_ispark_detail

import com.berkerdgn.isparkapp.data.remote.dto.IsparkDetailDto
import com.berkerdgn.isparkapp.domain.repository.IsparkRepository
import com.berkerdgn.isparkapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetIsparkDetailUseCase @Inject constructor(
    private val repository: IsparkRepository
) {

    fun executeGetIsparkDetails(parkID : String) : Flow<Resource<IsparkDetailDto>> = flow{
        try {
            emit(Resource.Loading())
            val isparkDetals = repository.getIsparkDetail(parkID)
            emit(Resource.Success(isparkDetals))
        }catch (e:Exception){
            emit(Resource.Error(message = e.localizedMessage ?: "Error in use_case"))
        }
    }

}