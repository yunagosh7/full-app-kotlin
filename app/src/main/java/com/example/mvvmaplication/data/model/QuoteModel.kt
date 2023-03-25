package com.example.mvvmaplication.data.model

import com.google.gson.annotations.SerializedName

data class QuoteModel(
    @SerializedName("q") val quote: String,
    @SerializedName("a") val author: String
)
