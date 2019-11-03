package dev.kirillzhelt.androidacademyapp.tasks.threadhandler

import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import dev.kirillzhelt.androidacademyapp.tasks.TaskEventContract

class CounterThreadTask(private val listener: TaskEventContract.Lifecycle) :
    TaskEventContract.Task {

    private var thread: Thread? = null

    override fun createTask() {
        thread = object : Thread() {
            override fun run() {
                repeat (10) {

                    if (!interrupted()) {
                        runOnUiThread(Runnable {
                            listener.onProgressUpdate(it)
                        })

                        SystemClock.sleep(500)
                    } else {
                        return
                    }
                }

                runOnUiThread(Runnable { listener.onPostExecute() })
            }
        }

        listener.onPreExecute()
    }

    override fun startTask(): Boolean? {
        thread?.start()

        return true
    }

    override fun cancelTask() {
        thread?.interrupt()
    }

    private fun runOnUiThread(runnable: Runnable) {
        Handler(Looper.getMainLooper()).post(runnable)
    }
}