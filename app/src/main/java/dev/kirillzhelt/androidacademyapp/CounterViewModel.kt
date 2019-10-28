package dev.kirillzhelt.androidacademyapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.lang.IllegalArgumentException

class CounterViewModel(application: Application, private val counterType: CounterType) : AndroidViewModel(application),
    TaskEventContract.Lifecycle {

    enum class CounterType {
        COROUTINES, THREAD_HANDLER
    }

    private var task: TaskEventContract.Task? = null
    private var running = false

    private val _counterText: MutableLiveData<String> by lazy {
        MutableLiveData<String>().apply {
            value = title
        }
    }

    val counterText: LiveData<String>
        get() = _counterText

    override fun onCleared() {
        super.onCleared()

        task?.cancelTask()
    }

    override fun onPreExecute() {
        _counterText.value = getApplication<Application>().resources.getString(R.string.task_created)
        running = true
    }

    override fun onPostExecute() {
        _counterText.value = getApplication<Application>().resources.getString(R.string.task_done)
        running = false
        task = null
    }

    override fun onProgressUpdate(progress: Int) {
        _counterText.value = progress.toString()
    }

    fun createTask() {
        task?.cancelTask()

        task = when (counterType) {
            CounterType.COROUTINES -> CounterCoroutineTask(this)
            CounterType.THREAD_HANDLER -> CounterThreadTask(this)
        }

        task?.createTask()
    }

    fun startTask() {
        if (task == null) {
            _counterText.value = "Create task before starting"
        } else {
            task?.startTask()
        }
    }

    fun cancelTask() {
        if (task == null) {
            _counterText.value = "Task is not created"
        } else if (!running) {
            _counterText.value = "Task is not running"
        } else {
            task?.cancelTask()
            task = null

            _counterText.value = title
        }
    }

    private val title: String by lazy {
        when (counterType) {
            CounterType.COROUTINES -> "Coroutines"
            CounterType.THREAD_HANDLER -> "Thread Handler"
        }
    }
}