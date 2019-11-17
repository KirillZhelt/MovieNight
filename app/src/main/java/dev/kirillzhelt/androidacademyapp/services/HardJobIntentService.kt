package dev.kirillzhelt.androidacademyapp.services

import android.app.IntentService
import android.content.Intent
import android.os.SystemClock
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class HardJobIntentService: IntentService("HardJobIntentService") {

    private var isDestroyed = false

    override fun onHandleIntent(intent: Intent?) {
        isDestroyed = false

        for (i in 0..100) {
            if (isDestroyed)
                break

            SystemClock.sleep(100)

            val broadcastIntent = Intent(BackgroundProgressReceiver.PROGRESS_UPDATE_ACTION).apply {
                putExtra(BackgroundProgressReceiver.PROGRESS_VALUE_KEY, i)
            }

            LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(broadcastIntent)
        }
    }
}