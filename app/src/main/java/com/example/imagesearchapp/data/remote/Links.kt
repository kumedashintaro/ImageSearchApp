package com.example.imagesearchapp.data.remote


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Links(
    val download: String?,
    val html: String?,
    val self: String?
)