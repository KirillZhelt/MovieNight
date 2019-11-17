package dev.kirillzhelt.androidacademyapp.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BackgroundProgressReceiver(val listener: (Int) -> Unit): BroadcastReceiver() {

    companion object {
        const val PROGRESS_UPDATE_ACTION = "PROGRESS_UPDATE_ACTION"

        const val PROGRESS_VALUE_KEY = "PROGRESS_VALUE_KEY"

        const val PROGRESS_STATUS = "PROGRESS_STATUS"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        val progress = intent?.getIntExtra(PROGRESS_VALUE_KEY, -1) ?: -1

        Log.i("Progress", progress.toString())

        listener(progress)
    }
}