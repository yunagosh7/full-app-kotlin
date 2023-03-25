package com.example.mvvmaplication.data.network

import com.example.mvvmaplication.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("api/quotes")
    suspend fun getAllQuotees(): Response<List<QuoteModel>>
}