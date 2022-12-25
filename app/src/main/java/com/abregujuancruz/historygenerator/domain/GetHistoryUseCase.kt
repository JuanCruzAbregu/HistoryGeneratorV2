package com.abregujuancruz.historygenerator.domain

import com.abregujuancruz.historygenerator.data.HistoryRepository
import com.abregujuancruz.historygenerator.data.database.entities.HistoryEntity
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(
    private val repository: HistoryRepository
) {
    
    suspend operator fun invoke(): List<HistoryEntity> {
        val histories = repository.getAllHistoryDataFromApi()

        return if (histories.isNotEmpty()) {
            repository.clearHistoryData()
            repository.insertHistoryData(histories)
            histories
        } else {
            repository.getAllHistoryDataFromDatabase()
        }
    }
}