package com.example.mvvmexample.data.network

import com.example.mvvmexample.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(private val api: QuoteApiClient){

    suspend fun  getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) { // lo que hace esta linea es ejecutar toda la llama en un hilo secundario y una vez que termine retornara el listado
            val response = api.getAllQuotes()
             response.body() ?: emptyList()
        }
    }
}