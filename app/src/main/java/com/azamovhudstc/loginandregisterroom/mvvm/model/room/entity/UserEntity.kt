package com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity

import androidx.room.PrimaryKey
import androidx.room.Entity

@Entity
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0,
    val name:String,
    val img:Int,
    val login:String,
    val password:String,
    val listCategory:String
)