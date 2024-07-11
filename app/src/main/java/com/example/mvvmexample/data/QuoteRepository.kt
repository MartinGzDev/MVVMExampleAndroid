package com.example.mvvmexample.data

import com.example.mvvmexample.data.database.dao.QuoteDao
import com.example.mvvmexample.data.database.entities.QuoteEntity
import com.example.mvvmexample.data.model.QuoteModel
import com.example.mvvmexample.data.model.QuoteProvider
import com.example.mvvmexample.data.network.QuoteService
import com.example.mvvmexample.domain.model.Quote
import com.example.mvvmexample.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService, private val quoteDAo: QuoteDao){

    suspend fun getAllQuotesFromApi():List<Quote>{
        val response = api.getQuotes()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote>{
        val response = quoteDAo.getAllQuotes()
        return  response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>){
        quoteDAo.insertAll(quotes)
    }

    suspend fun clearQuotes(){
        quoteDAo.deleteAllQuotes()
    }
}