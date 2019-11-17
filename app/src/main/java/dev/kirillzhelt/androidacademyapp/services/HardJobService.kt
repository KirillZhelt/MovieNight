package dev.kirillzhelt.androidacademyapp.services

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.*
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class HardJobService: Service() {

    private lateinit var serviceLooper: Looper
    private lateinit var serviceHandler: ServiceHandler

    override fun onCreate() {
        val thread = HandlerThread("HARD_JOB_SERVICE", Process.THREAD_PRIORITY_BACKGROUND)
        thread.start()

        serviceLooper = thread.looper
        serviceHandler = ServiceHandler(serviceLooper)
    }

    private inner class ServiceHandler(looper: Looper): Handler(looper) {

        override fun handleMessage(msg: Message) {
            for (i in 0..100) {
                SystemClock.sleep(100)

                val intent = Intent(BackgroundProgressReceiver.PROGRESS_UPDATE_ACTION)
                intent.putExtra(BackgroundProgressReceiver.PROGRESS_VALUE_KEY, i)
                LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(intent)
            }

            stopSelf(msg.arg1)
        }
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val message = serviceHandler.obtainMessage()
        message.arg1 = startId
        serviceHandler.sendMessage(message)

        return START_STICKY
    }
}