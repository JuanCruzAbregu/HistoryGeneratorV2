package com.abregujuancruz.historygenerator.data

import com.abregujuancruz.historygenerator.data.database.dao.HistoryDao
import com.abregujuancruz.historygenerator.data.database.entities.HistoryEntity
import com.abregujuancruz.historygenerator.data.network.ApiService
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HistoryRepository @Inject constructor(
    private val apiService: ApiService,
    private val historyDao: HistoryDao
) {
    
    suspend fun getAllHistoryDataFromApi(): List<HistoryEntity> =
        withContext(Dispatchers.IO){
            apiService.getHistoryData()
        }

    suspend fun getAllHistoryDataFromDatabase(): List<HistoryEntity> =
        withContext(Dispatchers.IO){
            historyDao.getAllHistoryData()
        }

    suspend fun insertHistoryData(historyList: List<HistoryEntity>) {
        historyDao.insertAllData(historyList)
    }
    
    suspend fun clearHistoryData() {
        historyDao.deleteAllData()
    }
    
}