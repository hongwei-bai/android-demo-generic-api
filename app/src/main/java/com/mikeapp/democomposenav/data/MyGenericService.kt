package com.mikeapp.democomposenav.data

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface MyGenericService {
    @GET
    suspend fun getRequest(
        @Url url: String,
        @QueryMap queryParams: Map<String, String> = emptyMap(),
        @HeaderMap headers: Map<String, String> = emptyMap()
    ): Response<ResponseBody>

    @POST
    suspend fun postRequest(
        @Url url: String,
        @Body body: RequestBody,
        @HeaderMap headers: Map<String, String> = emptyMap()
    ): Response<ResponseBody>
}