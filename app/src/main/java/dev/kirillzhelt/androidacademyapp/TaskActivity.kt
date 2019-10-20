package dev.kirillzhelt.androidacademyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        supportFragmentManager.beginTransaction()
            .add(R.id.activity_task_fragment_frm_lt, CounterFragment())
            .commit()
    }
}
