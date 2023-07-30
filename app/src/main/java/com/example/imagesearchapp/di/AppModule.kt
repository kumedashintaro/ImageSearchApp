package com.example.imagesearchapp.di

import com.example.imagesearchapp.common.Constants.BASE_URL
import com.example.imagesearchapp.data.remote.UnsplashApi
import com.example.imagesearchapp.data.repository.PhotoRepositoryImpl
import com.example.imagesearchapp.domain.repository.PhotoRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUnsplashApi(): UnsplashApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
            .create(UnsplashApi::class.java)
    }

    @Provides
    @Singleton
    fun providerPhotoRepository(api: UnsplashApi): PhotoRepository {
        return PhotoRepositoryImpl(api)
    }
}