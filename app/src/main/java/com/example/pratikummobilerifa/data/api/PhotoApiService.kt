package com.example.pratikummobilerifa.data.api

import com.example.pratikummobilerifa.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}