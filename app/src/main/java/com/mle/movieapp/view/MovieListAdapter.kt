package com.mle.movieapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mle.movieapp.databinding.ItemMovieBinding
import com.mle.movieapp.model.Movie

class MovieListAdapter(private var onItemViewClickListener: OnItemViewClickListener?) : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {

    private var movieData = listOf<Movie>()

    fun setData(data: List<Movie>) {
        movieData = data
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) = with(binding) {
            tvTitle.text = movie.title
            tvYear.text = movie.year.toString()
            tvRating.text = movie.rating.toString()
            tvMoviePoster.setImageResource(movie.poster)
            itemView.setOnClickListener{
                onItemViewClickListener?.onItemViewClick(movie)
            }
        }
    }

    interface OnItemViewClickListener {
        fun onItemViewClick(movie: Movie)
    }

    fun removeListener() {
        onItemViewClickListener = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieData[position])
    }

    override fun getItemCount(): Int {
        return movieData.size
    }
}