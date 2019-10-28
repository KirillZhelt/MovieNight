package dev.kirillzhelt.androidacademyapp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class CounterViewModelFactory(private val application: Application, private val counterType: CounterViewModel.CounterType) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CounterViewModel::class.java)) {
            return CounterViewModel(application, counterType) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}