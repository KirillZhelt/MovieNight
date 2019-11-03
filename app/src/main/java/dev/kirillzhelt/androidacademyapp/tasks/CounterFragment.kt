package dev.kirillzhelt.androidacademyapp.tasks


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dev.kirillzhelt.androidacademyapp.R
import java.lang.IllegalArgumentException

/**
 * A simple [Fragment] subclass.
 */
class CounterFragment : Fragment() {

    private lateinit var taskCreateButton: Button
    private lateinit var taskStartButton: Button
    private lateinit var taskCancelButton: Button

    private lateinit var counterTextView: TextView

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

        val counterType = when (arguments?.getString(ARGS_TASK_TYPE)) {
            ARGS_TASK_TYPE_COROUTINES -> CounterViewModel.CounterType.COROUTINES
            ARGS_TASK_TYPE_THREAD_HANDLER -> CounterViewModel.CounterType.THREAD_HANDLER
            else -> throw IllegalArgumentException("Illegal ARGS_TASK_TYPE argument")
        }

        val application = activity?.application ?: throw Exception("No activity for retrieving application")

        counterViewModel = ViewModelProviders.of(this,
            CounterViewModelFactory(
                application,
                counterType
            )
        )[CounterViewModel::class.java]
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

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskCreateButton.setOnClickListener {
            counterViewModel.createTask()
        }

        taskStartButton.setOnClickListener {
            counterViewModel.startTask()
        }

        taskCancelButton.setOnClickListener {
            counterViewModel.cancelTask()
        }

        counterViewModel.counterText.observe(this, Observer { value ->
            counterTextView.text = value
        })
    }
}
