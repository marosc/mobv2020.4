package com.example.viewmodel.data.api

import com.example.viewmodel.data.api.model.MarsResponse
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WebApi {
    @GET("realestate")
    suspend fun getProperties(): Response<List<MarsResponse>>

    companion object {
        private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

        fun create(): WebApi {
            val client = OkHttpClient.Builder().build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(WebApi::class.java)
        }
    }
}