package com.mle.movieapp.model

class MovieRepositoryImpl: MovieRepository {
    override fun getPlayingMoviesList(): List<Movie> {
        return getPlayingMovies()
    }

    override fun getUpcomingMoviesList(): List<Movie> {
        return getUpcomingMovies()
    }
}