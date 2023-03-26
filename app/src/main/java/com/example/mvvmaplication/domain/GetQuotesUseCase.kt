package com.example.mvvmaplication.domain

import com.example.mvvmaplication.data.QuoteRepository
import com.example.mvvmaplication.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()
}