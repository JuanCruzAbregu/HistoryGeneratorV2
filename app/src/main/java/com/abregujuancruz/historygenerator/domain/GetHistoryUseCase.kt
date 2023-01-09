package com.abregujuancruz.historygenerator.domain

import com.abregujuancruz.historygenerator.data.HistoryRepository
import com.abregujuancruz.historygenerator.data.database.entities.toDatabase
import com.abregujuancruz.historygenerator.domain.model.HistoryDomain
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(
    private val repository: HistoryRepository
) {
    
    suspend operator fun invoke(): List<HistoryDomain> {
        val histories = repository.getAllHistoryDataFromDatabase()
        return histories.ifEmpty {
            repository.getAllHistoryDataFromApi()
            repository.clearHistoryData()
            repository.insertHistoryData(histories.map { it.toDatabase() })
            histories
        }
    }
}