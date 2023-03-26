package com.example.mvvmaplication.domain

import com.example.mvvmaplication.data.model.QuoteModel
import com.example.mvvmaplication.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val quoteProvider: QuoteProvider
) {

    operator fun invoke(): QuoteModel? {
        val quotes = quoteProvider.quotes
        if(!quotes.isNullOrEmpty()) {
            val randomNum = (0..quotes.size - 1).random()
            return quotes[randomNum]
        }
        return null
    }
}