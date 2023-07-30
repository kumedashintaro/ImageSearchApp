package com.example.imagesearchapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imagesearchapp.presentation.search_photos.SearchPhotoScreen
import com.example.imagesearchapp.presentation.ui.theme.ImageSearchAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageSearchAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoute.SearchPhotoScreen.route
                    ) {
                        composable(route = ScreenRoute.SearchPhotoScreen.route) {
                            SearchPhotoScreen()
                        }
                        composable(route = ScreenRoute.PhotoDetailScreen.route) {
                            // TODO
                        }
                    }
                }
            }
        }
    }
}
