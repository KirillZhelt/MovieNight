package dev.kirillzhelt.androidacademyapp

import android.app.Application

class MovieApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: MovieApplication
    }
}