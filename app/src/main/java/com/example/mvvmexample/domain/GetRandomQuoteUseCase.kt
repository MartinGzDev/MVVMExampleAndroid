package com.example.mvvmexample.domain

import com.example.mvvmexample.data.QuoteRepository
import com.example.mvvmexample.data.model.QuoteModel
import com.example.mvvmexample.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    private val repository = QuoteRepository()

    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()){
            val randomNumber = quotes.indices.random()
            return quotes[randomNumber]
        }
        return null
    }
}