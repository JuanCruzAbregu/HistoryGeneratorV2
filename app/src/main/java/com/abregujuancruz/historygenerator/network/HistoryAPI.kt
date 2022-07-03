package com.abregujuancruz.historygenerator.network

import com.abregujuancruz.historygenerator.model.HistoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface HistoryAPI {
    
    @GET("results.json")
    fun getHistories(): Call<HistoryResponse>
    
}