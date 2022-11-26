package com.azamovhudstc.loginandregisterroom.mvvm.model.room.dao

import androidx.room.*
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.UserEntity
@Dao
interface UserDao {


    @Insert
    fun addUser(userEntity: UserEntity)


    @Update
    fun updateUser(userEntity: UserEntity)

    @Delete
    fun deleteUser(userEntity: UserEntity)

    @Query("select * from UserEntity")
    fun getAllUser():List<UserEntity>

}