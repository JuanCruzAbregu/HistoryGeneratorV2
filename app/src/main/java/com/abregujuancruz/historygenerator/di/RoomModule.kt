package com.abregujuancruz.historygenerator.di

import android.content.Context
import androidx.room.Room
import com.abregujuancruz.historygenerator.data.database.HistoryDatabase
import com.abregujuancruz.historygenerator.utils.Constants
import com.abregujuancruz.historygenerator.utils.Converters
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    
    @Singleton
    @Provides
    fun providesRoom(@ApplicationContext context : Context) =
        Room.databaseBuilder(context, HistoryDatabase::class.java,
            Constants.DATABASE_NAME)
//            .addTypeConverter(Converters::class)
            .build()
    
    @Singleton
    @Provides
    fun provideHistoryDao(db: HistoryDatabase) = db.getHistoryDao()
    
}