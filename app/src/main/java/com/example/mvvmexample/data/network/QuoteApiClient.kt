package com.example.mvvmexample.data.network

import com.example.mvvmexample.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    @GET(".json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}