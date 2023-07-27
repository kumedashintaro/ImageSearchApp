package com.example.imagesearchapp.data.remote


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UrlsX(
    val full: String?,
    val raw: String?,
    val regular: String?,
    val small: String?,
    val thumb: String?
)