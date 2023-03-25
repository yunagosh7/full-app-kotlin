package com.example.mvvmaplication.domain

import com.example.mvvmaplication.data.model.QuoteModel
import com.example.mvvmaplication.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()) {
            val randomNum = (0..quotes.size - 1).random()
            return quotes[randomNum]
        }
        return null
    }
}