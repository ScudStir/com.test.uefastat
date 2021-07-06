package com.test.uefastat

import android.app.Application

class MelApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        instance = this
    }

    companion object {
        lateinit var instance: MelApplication private set
    }
}