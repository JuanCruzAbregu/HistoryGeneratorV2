package com.abregujuancruz.historygenerator.network

import com.abregujuancruz.historygenerator.model.HistoryResponse
import com.abregujuancruz.historygenerator.utils.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIService : HistoryAPI {
    
    private lateinit var retrofit: Retrofit
    private lateinit var historyAPI: HistoryAPI
    
    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    override fun getHistories(): Call<HistoryResponse> {
        retrofit = getRetrofit()
        historyAPI = retrofit.create(HistoryAPI::class.java)
        return historyAPI.getHistories()
    }
    
}