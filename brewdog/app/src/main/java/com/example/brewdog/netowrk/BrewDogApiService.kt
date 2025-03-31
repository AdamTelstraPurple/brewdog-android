package com.example.brewdog.netowrk

import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private val BASE_URL = "https://punkapi.online/v3/"
private val retrofit = Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create()).baseUrl(
    BASE_URL).build()

object BrewDogApi {
    val retrofitService : BrewDogApiService by lazy {
        retrofit.create(BrewDogApiService::class.java)
    }
}

interface BrewDogApiService{
    @GET("beers")
    suspend fun getBeers(@Query("page")pageNumber: String) {
        return TODO("Provide the return value")
    }
}





