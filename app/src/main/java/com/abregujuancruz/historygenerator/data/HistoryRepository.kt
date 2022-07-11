package com.abregujuancruz.historygenerator.data

import com.abregujuancruz.historygenerator.data.database.dao.HistoryDao
import com.abregujuancruz.historygenerator.data.database.entities.HistoryEntity
import com.abregujuancruz.historygenerator.data.model.History
import com.abregujuancruz.historygenerator.data.network.ApiService
import com.abregujuancruz.historygenerator.domain.model.HistoryDomain
import com.abregujuancruz.historygenerator.domain.model.toDomain
import javax.inject.Inject

class HistoryRepository @Inject constructor(
    private val apiService: ApiService,
    private val historyDao: HistoryDao
) {
    
    suspend fun getAllHistoryDataFromApi(): List<HistoryDomain> {
        val response: List<History> = apiService.getHistoryData()
        return response.map { it.toDomain() }
    }
    
    suspend fun getAllHistoryDataFromDatabase(): List<HistoryDomain> {
        val response: List<HistoryEntity> = historyDao.getAllHistoryData()
        return response.map { it.toDomain() }
    }
    
    suspend fun insertHistoryData(historyList: List<HistoryEntity>) {
        historyDao.insertAllData(historyList)
    }
    
    suspend fun clearHistoryData() {
        historyDao.deleteAllData()
    }
    
}