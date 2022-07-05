package com.mle.movieapp.model

import android.os.Parcelable
import com.mle.movieapp.R
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Movie(val id: String, val title: String, val genre: String, val year: Int, val rating: Int, val poster: Int) : Parcelable

fun getPlayingMovies() : List<Movie> {
    return listOf(
        Movie(UUID.randomUUID().toString(),"Star Wars", "Fantasy", 2019, 5, R.drawable.starwars),
        Movie(UUID.randomUUID().toString(),"Godzilla", "Fantasy", 2000, 5,R.drawable.godzilla),
        Movie(UUID.randomUUID().toString(),"King's Speech", "Drama", 2018, 5,R.drawable.kingsspeech),
        Movie(UUID.randomUUID().toString(),"Big Papa", "Comedy", 1999, 5,R.drawable.bigpapa),
        Movie(UUID.randomUUID().toString(),"Fight Club", "Drama", 1999,5, R.drawable.fightclub),
        Movie(UUID.randomUUID().toString(),"When Harry Met Sally", "Romance", 1999,5, R.drawable.whenharrymetsally)
    )
}

fun getUpcomingMovies() : List<Movie> {
    return listOf(
        Movie(UUID.randomUUID().toString(),"Star Wars", "Fantasy", 2019, 5, R.drawable.starwars),
        Movie(UUID.randomUUID().toString(),"Godzilla", "Fantasy", 2000, 5,R.drawable.godzilla),
        Movie(UUID.randomUUID().toString(),"King's Speech", "Drama", 2018, 5,R.drawable.kingsspeech),
        Movie(UUID.randomUUID().toString(),"Big Papa", "Comedy", 1999, 5,R.drawable.bigpapa),
        Movie(UUID.randomUUID().toString(),"Fight Club", "Drama", 1999,5, R.drawable.fightclub),
        Movie(UUID.randomUUID().toString(),"When Harry Mey Sally", "Romance", 1999,5, R.drawable.whenharrymetsally)
    )
}
