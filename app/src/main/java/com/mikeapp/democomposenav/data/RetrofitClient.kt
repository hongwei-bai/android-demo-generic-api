package com.mikeapp.democomposenav.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val logging = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://example.com/") // Placeholder, will be overridden
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: MyGenericService = retrofit.create(MyGenericService::class.java)
}