package com.abregujuancruz.historygenerator.data.network

import com.abregujuancruz.historygenerator.data.database.entities.HistoryEntity
import com.abregujuancruz.historygenerator.data.model.History
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface HistoryAPI {
    
    @GET("results.json")
    suspend fun getHistories(): Response<List<HistoryEntity>>
    
}