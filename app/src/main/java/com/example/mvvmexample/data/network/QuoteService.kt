package com.example.mvvmexample.data.network

import com.example.mvvmexample.core.RetrofitHelper
import com.example.mvvmexample.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun  getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) { // lo que hace esta linea es ejecutar toda la llama en un hilo secundario y una vez que termine retornara el listado
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
             response.body() ?: emptyList()
        }
    }
}