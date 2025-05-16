package com.mikeapp.democomposenav.data

import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class MyRepository() {
    suspend fun callGet() {
        val response = RetrofitClient.api.getRequest(
            url = "https://httpbin.org/get",
            queryParams = mapOf("q" to "test"),
            headers = mapOf("Authorization" to "Bearer token")
        )

        if (response.isSuccessful) {
            val result = response.body()?.string()
            println(result)
        } else {
            println("Error: ${response.code()} - ${response.message()}")
        }
    }

    suspend fun callPost() {
        val jsonBody = JSONObject()
        jsonBody.put("username", "john")
        jsonBody.put("password", "secret")

        val requestBody = jsonBody.toString()
            .toRequestBody("application/json".toMediaType())

        val response = RetrofitClient.api.postRequest(
            url = "https://httpbin.org/post",
            body = requestBody,
            headers = mapOf("Authorization" to "Bearer token")
        )

        if (response.isSuccessful) {
            val result = response.body()?.string()
            println(result)
        } else {
            println("Error: ${response.code()} - ${response.message()}")
        }
    }
}