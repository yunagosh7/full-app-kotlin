package com.example.mvvmaplication.data

import com.example.mvvmaplication.data.model.QuoteModel
import com.example.mvvmaplication.data.model.QuoteProvider
import com.example.mvvmaplication.data.network.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response: List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}