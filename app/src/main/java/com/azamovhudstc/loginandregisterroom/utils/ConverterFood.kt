package com.azamovhudstc.loginandregisterroom.utils

import androidx.room.TypeConverter
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.CategoryEntity
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.FoodEntity
import com.google.gson.Gson

class ConverterFood  {
    @TypeConverter
    fun fromFoodToJSON(foodList: List<FoodEntity>): String {
        return Gson().toJson(foodList)
    }
    @TypeConverter
    fun fromJSONToFood(foodList: String): List<FoodEntity> {
        return listOf(Gson().fromJson(foodList, FoodEntity::class.java))
    }
}