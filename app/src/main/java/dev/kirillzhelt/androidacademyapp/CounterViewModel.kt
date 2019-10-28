package dev.kirillzhelt.androidacademyapp

import androidx.lifecycle.ViewModel

class CounterViewModel(private val counterType: CounterType) : ViewModel() {

    enum class CounterType {
        COROUTINES, THREAD_HANDLER
    }



}