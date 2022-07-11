package com.abregujuancruz.historygenerator.domain.model

import com.abregujuancruz.historygenerator.data.database.entities.HistoryEntity
import com.abregujuancruz.historygenerator.data.model.History

data class HistoryDomain(val label : String, val data : List<String>)

fun History.toDomain() = HistoryDomain(label, data)
fun HistoryEntity.toDomain() = HistoryDomain(label, data)