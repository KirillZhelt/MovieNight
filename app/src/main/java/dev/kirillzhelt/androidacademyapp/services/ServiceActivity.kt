package dev.kirillzhelt.androidacademyapp.services

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import dev.kirillzhelt.androidacademyapp.R

class ServiceActivity : AppCompatActivity() {

    private lateinit var progressTextView: TextView

    private var backgroundProgressReceiver: BackgroundProgressReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        progressTextView = findViewById(R.id.activity_service_progress_tv)

        findViewById<Button>(R.id.activity_service_start_intent_service_btn).setOnClickListener {
            Intent(this, HardJobIntentService::class.java).also { intent ->
                startService(intent)
            }
        }

        findViewById<Button>(R.id.activity_service_start_service_btn).setOnClickListener {

        }
    }

    override fun onResume() {
        super.onResume()

        subscribeForProgressUpdates()
    }

    override fun onPause() {
        if (backgroundProgressReceiver != null) {
            unregisterReceiver(backgroundProgressReceiver)
        }

        super.onPause()
    }

    private fun subscribeForProgressUpdates() {
        if (backgroundProgressReceiver == null) {
            backgroundProgressReceiver = BackgroundProgressReceiver { progress ->
                progressTextView.text = progress.toString()
            }
        }

        val progressUpdateActionFilter = IntentFilter(BackgroundProgressReceiver.PROGRESS_UPDATE_ACTION)

        LocalBroadcastManager.getInstance(applicationContext).registerReceiver(backgroundProgressReceiver!!,
            progressUpdateActionFilter)
    }
}
