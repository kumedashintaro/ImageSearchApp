package com.example.imagesearchapp.presentation.search_photos

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.Lazy

@Composable
fun SearchPhotoScreen(
    viewModel: SearchPhotoViewModel = hiltViewModel(),
){
    val state = viewModel.state.value
    LazyColumn{
        items(state.photos){ photo ->
            Text(text = photo.imageUrl)
        }
    }
}