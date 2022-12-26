package com.abregujuancruz.historygenerator.domain.model

import com.abregujuancruz.historygenerator.data.database.entities.HistoryEntity
import com.abregujuancruz.historygenerator.data.model.History
import com.google.gson.annotations.SerializedName

data class HistoryDomain(
    @SerializedName("label") val label: String,
    @SerializedName("data") val data: List<String>
)

fun History.toDomain() = HistoryDomain(label, data)
fun HistoryEntity.toDomain() = HistoryDomain(label, data)