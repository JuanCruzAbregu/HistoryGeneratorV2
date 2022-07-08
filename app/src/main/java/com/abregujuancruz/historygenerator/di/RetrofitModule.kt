package com.abregujuancruz.historygenerator.di

import com.abregujuancruz.historygenerator.data.network.HistoryAPI
import com.abregujuancruz.historygenerator.di.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    
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