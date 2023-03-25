package com.example.mvvmaplication.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmaplication.data.model.QuoteModel
import com.example.mvvmaplication.data.model.QuoteProvider
import com.example.mvvmaplication.domain.GetQuotesUseCase
import com.example.mvvmaplication.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    var getQuotesUseCase = GetQuotesUseCase()
    var getRandomQuoteUseCase = GetRandomQuoteUseCase()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)

        viewModelScope.launch {
            val quote = getRandomQuoteUseCase()

            if(quote != null) {
                quoteModel.postValue(quote)
            }
        }

        isLoading.postValue(false)
    }


}