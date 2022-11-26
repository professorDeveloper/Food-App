package com.azamovhudstc.loginandregisterroom.mvvm.model.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.dao.CategoryDao
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.dao.FoodDao
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.dao.UserDao
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.CategoryEntity
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.FoodEntity
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity.UserEntity


@Database(entities = [CategoryEntity::class,UserEntity::class,FoodEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getFoodDao():FoodDao
    abstract fun getUserDao():UserDao
    abstract fun  getCategoryDao():CategoryDao
    companion object{
        private var instance: AppDatabase?=null
        fun getInstance(): AppDatabase {
            return instance!!
        }
        fun init(context: Context): AppDatabase {
            return instance ?: Room.databaseBuilder(context, AppDatabase::class.java,"note.db")
                .allowMainThreadQueries()
                .build().also {
                    instance =it
                }
        }
    }

}