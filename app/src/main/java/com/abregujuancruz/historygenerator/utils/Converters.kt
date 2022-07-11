package com.abregujuancruz.historygenerator.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {
    
    @TypeConverter
    fun fromListToString(dataList: List<String>): String = Gson().toJson(dataList)
    
    @TypeConverter
    fun fromString(value: String): List<String> {
        val listType: Type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }
}