package com.example.imagesearchapp.data.remote


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tag(
    val title: String?
)