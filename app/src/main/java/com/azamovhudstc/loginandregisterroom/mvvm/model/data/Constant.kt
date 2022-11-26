package com.azamovhudstc.loginandregisterroom.mvvm.model.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class Constant private constructor(context: Context){
   private var sharedPreferences:SharedPreferences=context.getSharedPreferences("shared",MODE_PRIVATE)
    fun setBool(boolean: Boolean){
        sharedPreferences.edit().putBoolean("bool",boolean).apply()
    }
    fun getBool():Boolean{
        return sharedPreferences.getBoolean("bool",true)
    }

    companion object{
        private var instances:Constant?=null


        fun getInstance():Constant{

            return instances!!
        }
        fun init(context: Context){
            if (instances==null){
                instances=Constant(context)
            }
        }
    }
}