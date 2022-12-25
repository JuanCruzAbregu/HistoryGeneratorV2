package com.abregujuancruz.historygenerator.data.network

import com.abregujuancruz.historygenerator.data.database.entities.HistoryEntity
import com.abregujuancruz.historygenerator.data.model.History
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ApiService @Inject constructor(private val historyApi: HistoryAPI) {
    
    suspend fun getHistoryData(): List<HistoryEntity> =
        withContext(Dispatchers.IO) {
            val response = historyApi.getHistories()
            response.body() ?: emptyList()
        }
}