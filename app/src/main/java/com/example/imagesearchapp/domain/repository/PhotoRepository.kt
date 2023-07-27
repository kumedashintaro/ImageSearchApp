package com.example.imagesearchapp.domain.repository

import com.example.imagesearchapp.data.remote.PhotoDetailDto
import com.example.imagesearchapp.data.remote.SearchPhotosResultDto

interface PhotoRepository {

    suspend fun searchPhotos(query: String): SearchPhotosResultDto

    suspend fun gerPhotoById(photoId: String): PhotoDetailDto
}