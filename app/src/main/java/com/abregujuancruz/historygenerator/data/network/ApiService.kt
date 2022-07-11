package com.abregujuancruz.historygenerator.data.network

import com.abregujuancruz.historygenerator.data.model.History
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiService @Inject constructor(private val historyApi: HistoryAPI) {
    
    suspend fun getHistoryData(): List<History> {
        return withContext(Dispatchers.IO) {
            val response = historyApi.getHistories()
            response.body() ?: emptyList()
        }
    }
    
}