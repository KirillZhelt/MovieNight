package dev.kirillzhelt.androidacademyapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import java.lang.IllegalArgumentException

/**
 * A simple [Fragment] subclass.
 */
class CounterFragment : Fragment(), TaskEventContract.Lifecycle {

    private lateinit var taskCreateButton: Button
    private lateinit var taskStartButton: Button
    private lateinit var taskCancelButton: Button

    private lateinit var counterTextView: TextView

    private var task: TaskEventContract.Task? = null

    private lateinit var counterViewModel: CounterViewModel

    companion object {
        private const val ARGS_TASK_TYPE = "ARGS_TASK_TYPE"

        const val ARGS_TASK_TYPE_COROUTINES = "ARGS_TASK_TYPE_COROUTINES"
        const val ARGS_TASK_TYPE_THREAD_HANDLER = "ARGS_TASK_TYPE_THREAD_HANDLER"

        fun newInstance(taskType: String): CounterFragment {
            val instance = CounterFragment()

            val bundle = Bundle().apply {
                putString(ARGS_TASK_TYPE, taskType)
            }
            instance.arguments = bundle

            return instance
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        counterViewModel = ViewModelProviders.of(this)[CounterViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_counter, container, false)

        taskCreateButton = view.findViewById(R.id.fragment_counter_create_btn)
        taskStartButton = view.findViewById(R.id.fragment_counter_start_btn)
        taskCancelButton = view.findViewById(R.id.fragment_counter_cancel_btn)

        counterTextView = view.findViewById(R.id.fragment_counter_tv)

        taskCreateButton.setOnClickListener {
            buildTask()

            task?.createTask()
        }

        taskStartButton.setOnClickListener {
            task?.startTask()
        }

        taskCancelButton.setOnClickListener {
            task?.cancelTask()

            counterTextView.text = arguments?.getString(ARGS_TASK_TYPE) ?: throw IllegalArgumentException()
        }

        counterTextView.text = arguments?.getString(ARGS_TASK_TYPE) ?: throw IllegalArgumentException()

        return view
    }

    override fun onDestroy() {
        super.onDestroy()

        task?.cancelTask()
    }

    override fun onPreExecute() {
        counterTextView.text = getString(R.string.task_created)
    }

    override fun onPostExecute() {
        counterTextView.text = getString(R.string.task_done)
    }

    override fun onProgressUpdate(progress: Int) {
        counterTextView.text = progress.toString()
    }

    private fun buildTask() {
        task = when (arguments?.getString(ARGS_TASK_TYPE)) {
            ARGS_TASK_TYPE_COROUTINES -> CounterCoroutineTask(this)
            ARGS_TASK_TYPE_THREAD_HANDLER -> CounterThreadTask(this)
            else -> throw IllegalArgumentException()
        }
    }
}
