package dev.kirillzhelt.androidacademyapp.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.kirillzhelt.androidacademyapp.model.Movie
import dev.kirillzhelt.androidacademyapp.model.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel: ViewModel() {

    private val repository: Repository = Repository()

    private val _movies = MutableLiveData<ArrayList<Movie>>()

    val movies: LiveData<ArrayList<Movie>>
        get() = _movies

    private val _currentMoviePosition = MutableLiveData<Int>()

    val currentMoviePosition: LiveData<Int>
        get() = _currentMoviePosition

    private val _navigateDetailsEvent =  MutableLiveData<Boolean>(false)

    val navigateDetailsEvent: LiveData<Boolean>
        get() = _navigateDetailsEvent

    init {

        viewModelScope.launch(Dispatchers.IO) {
            _movies.postValue(repository.loadMoviesFromNetwork())
        }

    }

    fun onNavigateDetails(moviePosition: Int) {
        _navigateDetailsEvent.value = true
        _currentMoviePosition.value = moviePosition
    }

    fun onNavigateDetailsComplete() {
        _navigateDetailsEvent.value = false
    }

}