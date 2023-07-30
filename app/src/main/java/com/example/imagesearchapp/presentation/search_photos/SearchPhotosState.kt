package com.example.imagesearchapp.presentation.search_photos

import com.example.imagesearchapp.domain.model.Photo

data class SearchPhotosState(
    val isLoading: Boolean = false,
    val photos: List<Photo> = emptyList(),
    val error: String? = null
)
