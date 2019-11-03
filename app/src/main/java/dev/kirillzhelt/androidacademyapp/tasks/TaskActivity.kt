package dev.kirillzhelt.androidacademyapp.tasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.kirillzhelt.androidacademyapp.R
import java.lang.IllegalArgumentException

class TaskActivity : AppCompatActivity() {

    companion object {
        const val ARGS_TASK_TYPE = "ARGS_TASK_TYPE"

        const val ARGS_TASK_TYPE_COROUTINES = "ARGS_TASK_TYPE_COROUTINES"
        const val ARGS_TASK_TYPE_THREAD_HANDLER = "ARGS_TASK_TYPE_THREAD_HANDLER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val taskType = when (intent.getStringExtra(ARGS_TASK_TYPE)) {
            ARGS_TASK_TYPE_COROUTINES -> CounterFragment.ARGS_TASK_TYPE_COROUTINES
            ARGS_TASK_TYPE_THREAD_HANDLER -> CounterFragment.ARGS_TASK_TYPE_THREAD_HANDLER
            else -> throw IllegalArgumentException("TaskActivity.ARGS_TASK_TYPE invalid value")
        }

        val counterFragment = CounterFragment.newInstance(taskType)

        supportFragmentManager.beginTransaction()
            .add(R.id.activity_task_fragment_frm_lt, counterFragment)
            .commit()
    }
}
