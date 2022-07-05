package com.mle.movieapp.model

interface MovieRepository {
    fun getPlayingMoviesList() : List<Movie>
    fun getUpcomingMoviesList() : List<Movie>
}