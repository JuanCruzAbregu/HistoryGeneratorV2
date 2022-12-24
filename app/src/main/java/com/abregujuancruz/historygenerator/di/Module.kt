package com.abregujuancruz.historygenerator.di

import android.content.Context
import androidx.room.Room
import com.abregujuancruz.historygenerator.data.database.HistoryDatabase
import com.abregujuancruz.historygenerator.data.network.HistoryAPI
import com.abregujuancruz.historygenerator.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object Module {
    
    @Singleton
    @Provides
    fun providesRoom(@ApplicationContext context : Context) =
        Room.databaseBuilder(context, HistoryDatabase::class.java,
            Constants.DATABASE_NAME)
            .build()
    
    @Singleton
    @Provides
    fun provideHistoryDao(db: HistoryDatabase) = db.getHistoryDao()

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesHistoryApi(retrofit: Retrofit): HistoryAPI {
        return retrofit.create(HistoryAPI::class.java)
    }
    
}