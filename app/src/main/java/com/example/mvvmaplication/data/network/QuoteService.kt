package com.example.mvvmaplication.data.network

import com.example.mvvmaplication.core.RetrofitHelper
import com.example.mvvmaplication.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.create
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val api: QuoteApiClient
) {
    

    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllQuotees()
            response.body() ?: emptyList()
        }
    }
}