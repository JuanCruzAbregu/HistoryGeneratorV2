package com.abregujuancruz.historygenerator.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "history_table")
@TypeConverters
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "label") val label: String,
    @ColumnInfo(name = "data") val data: List<String>
)

