package com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int=0

)