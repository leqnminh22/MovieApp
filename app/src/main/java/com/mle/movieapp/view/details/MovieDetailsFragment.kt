package com.mle.movieapp.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mle.movieapp.databinding.FragmentMovieDetailsBinding
import com.mle.movieapp.model.Movie

class MovieDetailsFragment : Fragment() {

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val movie = arguments?.getParcelable<Movie>(ARG_MOVIE)
        if (movie != null) {
            showMovie(movie)
        }
    }

    private fun showMovie(movie: Movie) {
        binding.tvTitle.text = movie.title
        binding.tvMoviePoster.setImageResource(movie.poster)
        binding.tvYear.text = movie.year.toString()
        binding.tvRating.text = movie.rating.toString()
    }

    companion object {
        const val ARG_MOVIE = "ARG_MOVIE"

        fun newInstance(bundle: Bundle) = MovieDetailsFragment().apply {
            arguments = bundle
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}