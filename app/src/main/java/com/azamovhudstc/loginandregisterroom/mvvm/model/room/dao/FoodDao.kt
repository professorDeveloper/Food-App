package com.azamovhudstc.loginandregisterroom.mvvm.model.room.dao

import androidx.room.*
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.FoodEntity
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.UserEntity
@Dao
interface FoodDao  {
    @Insert
    fun add(userEntity: FoodEntity)


    @Update
    fun update(userEntity: FoodEntity)

    @Delete
    fun delete(userEntity: FoodEntity)

    @Query("select * from FoodEntity")
    fun getAllUser():List<FoodEntity>
}