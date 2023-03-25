package com.example.mvvmaplication.domain

import com.example.mvvmaplication.data.QuoteRepository
import com.example.mvvmaplication.data.model.QuoteModel

class GetQuotesUseCase {
    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}