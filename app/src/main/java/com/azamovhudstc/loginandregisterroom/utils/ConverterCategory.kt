package com.azamovhudstc.loginandregisterroom.utils

import androidx.room.TypeConverter
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.CategoryEntity
import com.google.gson.Gson

class ConverterCategory  {
    @TypeConverter
    fun fromClothingToJSON(categoryList: List<CategoryEntity>): String {
        return Gson().toJson(categoryList)
    }
    @TypeConverter
    fun fromJSONToClothing(categoryList: String): List<CategoryEntity> {
        return listOf(Gson().fromJson(categoryList, CategoryEntity::class.java))
    }
}