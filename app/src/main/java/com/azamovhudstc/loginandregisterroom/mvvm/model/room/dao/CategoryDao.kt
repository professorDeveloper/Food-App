package com.azamovhudstc.loginandregisterroom.mvvm.model.room.dao

import androidx.room.*
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.CategoryEntity
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.UserEntity
@Dao
interface CategoryDao {
    @Insert
    fun addCategory(userEntity: CategoryEntity)


    @Update
    fun updateCategory(userEntity: CategoryEntity)

    @Delete
    fun deleteCategory(userEntity: CategoryEntity)

    @Query("select * from CategoryEntity")
    fun getAllCategory():List<CategoryEntity>
}