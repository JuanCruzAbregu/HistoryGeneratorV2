package com.abregujuancruz.historygenerator.data.network

import com.abregujuancruz.historygenerator.data.model.History
import retrofit2.Response
import retrofit2.http.GET

interface HistoryAPI {
    
    @GET("results.json")
    suspend fun getHistories(): Response<List<History>>
    
}