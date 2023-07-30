package com.example.imagesearchapp.presentation

sealed class ScreenRoute(val route: String) {
    object SearchPhotoScreen : ScreenRoute("search_photos_screen")
    object PhotoDetailScreen: ScreenRoute("photo_detail_screen")
}
