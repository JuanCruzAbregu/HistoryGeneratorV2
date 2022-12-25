package com.abregujuancruz.historygenerator.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abregujuancruz.historygenerator.data.database.entities.HistoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    
    @Query("SELECT * FROM history_table")
    suspend fun getAllHistoryData(): List<HistoryEntity>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllData(quotes:List<HistoryEntity>)
    
    @Query("DELETE FROM history_table")
    suspend fun deleteAllData()
}