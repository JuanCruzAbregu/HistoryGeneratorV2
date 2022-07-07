package com.abregujuancruz.historygenerator.domain

import com.abregujuancruz.historygenerator.data.network.HistoryAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoadHistoriesUseCase @Inject constructor(
    private val historyAPi: HistoryAPI
) {
    
    suspend operator fun invoke() = withContext(Dispatchers.IO) {
        historyAPi.getHistories()
    }
    
}