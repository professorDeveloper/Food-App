package com.azamovhudstc.loginandregisterroom.app

import android.app.Application
import com.azamovhudstc.loginandregisterroom.mvvm.model.data.Constant
import com.azamovhudstc.loginandregisterroom.mvvm.model.room.database.AppDatabase

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        Constant.init(this)
        AppDatabase.init(this)
    }
}