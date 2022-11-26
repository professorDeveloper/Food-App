package com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FoodEntity(
    @PrimaryKey
    var id:Int,
    val name:String,
    val date:String,
    val company:String,
    val dateYaroq:String,
    var price:Int,
    val dona:Int,
)