package com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val foods:String


)