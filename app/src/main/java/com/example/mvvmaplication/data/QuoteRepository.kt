package com.example.mvvmaplication.data

import com.example.mvvmaplication.data.model.QuoteModel
import com.example.mvvmaplication.data.model.QuoteProvider
import com.example.mvvmaplication.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider
) {

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response: List<QuoteModel> = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}