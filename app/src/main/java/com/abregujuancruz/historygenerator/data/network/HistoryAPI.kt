package com.abregujuancruz.historygenerator.data.network

import com.abregujuancruz.historygenerator.data.model.HistoryResponse
import retrofit2.Call
import retrofit2.http.GET

interface HistoryAPI {
    
    @GET("results.json")
    fun getHistories(): Call<HistoryResponse>
    
}