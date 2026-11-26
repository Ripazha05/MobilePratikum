package com.example.pratikummobilerifa.data.api

import com.example.pratikummobilerifa.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}
