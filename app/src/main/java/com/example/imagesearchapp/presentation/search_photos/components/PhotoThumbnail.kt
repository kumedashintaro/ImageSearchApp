package com.example.imagesearchapp.presentation.search_photos.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.imagesearchapp.domain.model.Photo
import com.example.imagesearchapp.presentation.ui.theme.ImageSearchAppTheme

@Composable
fun PhotoThumbnail(
    photo: Photo,
    onClick: (Photo) -> Unit,
) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .clickable { onClick(photo) },
        contentAlignment = Alignment.BottomCenter
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        AsyncImage(
            model = photo.imageUrl,
            contentDescription = photo.description,
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.5f))
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
            ) {
                Text(
                    text = photo.description ?: "No description",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = photo.photographer ?: "Unknown photographer",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "likes",
                tint = Color.Magenta
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = photo.likes.toString(),
                color = Color.White,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview
@Composable
private fun PhotoThumbnailPreview() {
    val photo = Photo(
        photoId = "",
        description = " description",
        likes = 100,
        imageUrl = "https://unsplash.com/ja/%E5%86%99%E7%9C%9F/%E3%83%97%E3%83%BC%E3%83%AB%E3%81%AE%E7%AB%AF%E3%81%AB%E5%BA%A7%E3%81%A3%E3%81%A6%E3%81%84%E3%82%8B%E4%B8%80%E6%9D%AF%E3%81%AE%E3%82%B3%E3%83%BC%E3%83%92%E3%83%BC-QxETQsRocGg",
        photographer = "photographer"
    )
    
    ImageSearchAppTheme {
        PhotoThumbnail(photo = photo, onClick = {})
    }
}
