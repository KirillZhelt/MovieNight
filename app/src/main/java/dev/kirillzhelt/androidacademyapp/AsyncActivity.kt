package dev.kirillzhelt.androidacademyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

open class AsyncActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)
    }
}
