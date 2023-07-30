package com.example.imagesearchapp.domain.use_case

import com.example.imagesearchapp.common.NetworkResponse
import com.example.imagesearchapp.data.remote.toPhotoDetail
import com.example.imagesearchapp.domain.model.PhotoDetail
import com.example.imagesearchapp.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPhotoDetailUseCase @Inject constructor(
    private val repository: PhotoRepository,
) {
    operator fun invoke(photoId: String): Flow<NetworkResponse<PhotoDetail>> = flow {
        try {
            emit(NetworkResponse.Loading<PhotoDetail>())
            val photoDetail = repository.gerPhotoById(photoId).toPhotoDetail()
            emit(NetworkResponse.Success<PhotoDetail>(photoDetail))
        } catch (e: Exception) {
            emit(NetworkResponse.Failure<PhotoDetail>(e.message.toString()))
        }
    }
}
