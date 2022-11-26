package com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class FoodEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    var name:String,
    val date:String,
    var company:String,
    var dateYaroq:String,
    var price:String,
    var dona:String,
    var category_id:Int
):Serializable