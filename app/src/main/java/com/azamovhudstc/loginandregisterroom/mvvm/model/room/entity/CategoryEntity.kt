package com.azamovhudstc.loginandregisterroom.mvvm.model.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    var name:String,


    ) : Serializable {
    override fun toString(): String {
        return "CategoryEntity(id=$id, name='$name')"
    }
}