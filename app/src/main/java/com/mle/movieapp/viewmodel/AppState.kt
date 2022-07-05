package com.mle.movieapp.viewmodel

import com.mle.movieapp.model.Movie

sealed class AppState {
    data class Success(val moviesData: List<Movie>) : AppState()
    data class Error(val e: Throwable) : AppState()
    object Loading : AppState()
}