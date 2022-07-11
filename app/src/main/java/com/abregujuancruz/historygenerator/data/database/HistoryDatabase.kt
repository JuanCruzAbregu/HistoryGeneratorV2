package com.abregujuancruz.historygenerator.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.abregujuancruz.historygenerator.data.database.dao.HistoryDao
import com.abregujuancruz.historygenerator.utils.Converters
import com.abregujuancruz.historygenerator.data.database.entities.HistoryEntity

@Database(entities = [HistoryEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class HistoryDatabase : RoomDatabase() {
    
    abstract fun getHistoryDao():HistoryDao
    
}