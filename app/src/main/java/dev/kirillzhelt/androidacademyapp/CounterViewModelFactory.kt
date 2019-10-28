package dev.kirillzhelt.androidacademyapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class CounterViewModelFactory(private val counterType: CounterViewModel.CounterType) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CounterViewModel::class.java)) {
            return CounterViewModel(counterType) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}