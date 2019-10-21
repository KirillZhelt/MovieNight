package dev.kirillzhelt.androidacademyapp


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class CounterFragment : Fragment() {

    private lateinit var taskCreateButton: Button
    private lateinit var taskStartButton: Button
    private lateinit var taskCancelButton: Button

    private lateinit var counterTextView: TextView

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

        }

        counterTextView.text = arguments!!.getString(ARGS_TASK_TYPE)

        return view
    }


}
