package com.example.imagesearchapp.data.repository

import com.example.imagesearchapp.data.remote.PhotoDetailDto
import com.example.imagesearchapp.data.remote.SearchPhotosResultDto
import com.example.imagesearchapp.data.remote.UnsplashApi
import com.example.imagesearchapp.domain.repository.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val api: UnsplashApi
) : PhotoRepository {

    override suspend fun searchPhotos(query: String): SearchPhotosResultDto {
        return api.searchPhotos(query)
    }

    override suspend fun gerPhotoById(photoId: String): PhotoDetailDto {
        return api.getPhotoById(photoId)
    }
}