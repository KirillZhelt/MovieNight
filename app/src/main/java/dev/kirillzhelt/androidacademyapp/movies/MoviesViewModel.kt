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

    init {

        viewModelScope.launch(Dispatchers.IO) {
            _movies.postValue(repository.loadMoviesFromNetwork())
        }

    }



}