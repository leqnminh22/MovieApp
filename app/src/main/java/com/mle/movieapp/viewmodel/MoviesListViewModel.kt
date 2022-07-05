package com.mle.movieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mle.movieapp.model.MovieRepository
import com.mle.movieapp.model.MovieRepositoryImpl
import java.lang.Thread.sleep

class MoviesListViewModel(
    private val liveDataPlaying: MutableLiveData<AppState> = MutableLiveData(),
    private val liveDataUpcoming: MutableLiveData<AppState> = MutableLiveData(),
    private val movieRepositoryImpl: MovieRepository = MovieRepositoryImpl()
    ) : ViewModel() {

    fun getPlayingLiveData(): LiveData<AppState> {
        return liveDataPlaying
    }

    fun getUpcomingLiveData(): LiveData<AppState> {
        return liveDataUpcoming
    }

    fun getMoviesListOne() = getPlayingDataFromLocalSource()
    fun getMoviesListTwo() = getUpcomingDataFromLocalSource()

    private fun getPlayingDataFromLocalSource() {
        liveDataPlaying.value = AppState.Loading
        Thread {
            sleep(1000L)
            liveDataPlaying.postValue(AppState.Success(movieRepositoryImpl.getPlayingMoviesList()))
        }.start()
    }

    private fun getUpcomingDataFromLocalSource() {
        liveDataPlaying.value = AppState.Loading
        Thread {
            sleep(1000L)
            liveDataPlaying.postValue(AppState.Success(movieRepositoryImpl.getUpcomingMoviesList()))
        }.start()
    }
}