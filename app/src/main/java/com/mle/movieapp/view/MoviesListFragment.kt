package com.mle.movieapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mle.movieapp.R
import com.mle.movieapp.databinding.FragmentMoviesListBinding
import com.mle.movieapp.model.Movie
import com.mle.movieapp.view.details.MovieDetailsFragment
import com.mle.movieapp.viewmodel.AppState
import com.mle.movieapp.viewmodel.MoviesListViewModel

class MoviesListFragment : Fragment() {

    private var _binding: FragmentMoviesListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MoviesListViewModel
    private val adapterOne = MovieListAdapter(object : MovieListAdapter.OnItemViewClickListener {
        override fun onItemViewClick(movie: Movie) {
            val manager = activity?.supportFragmentManager

            if (manager != null) {
                val bundle = Bundle()
                bundle.putParcelable(MovieDetailsFragment.ARG_MOVIE, movie)
                manager.beginTransaction()
                    .add(R.id.container, MovieDetailsFragment.newInstance(bundle))
                    .hide(this@MoviesListFragment)
                    .addToBackStack("")
                    .commitAllowingStateLoss()
            }
        }
    })

    private val adapterTwo = MovieListAdapter(object : MovieListAdapter.OnItemViewClickListener {
        override fun onItemViewClick(movie: Movie) {
            val manager = activity?.supportFragmentManager

            if (manager != null) {
                val bundle = Bundle()
                bundle.putParcelable(MovieDetailsFragment.ARG_MOVIE, movie)
                manager.beginTransaction()
                    .add(R.id.container, MovieDetailsFragment.newInstance(bundle))
                    .hide(this@MoviesListFragment)
                    .addToBackStack("")
                    .commitAllowingStateLoss()
            }
        }
    })

    companion object {
        fun newInstance() = MoviesListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcMovieListOne.adapter = adapterOne
        binding.rcMovieListOne.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.rcMovieListTwo.adapter = adapterTwo
        binding.rcMovieListTwo.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.HORIZONTAL, false)

        viewModel = ViewModelProvider(this).get(MoviesListViewModel::class.java)
        val observer = Observer<AppState> { renderData(it) }
        viewModel.getPlayingLiveData().observe(viewLifecycleOwner, observer)
        viewModel.getUpcomingLiveData().observe(viewLifecycleOwner,observer)
        viewModel.getMoviesListOne()
        viewModel.getMoviesListTwo()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            AppState.Loading -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            is AppState.Success -> {
                adapterOne.setData(appState.moviesData)
                adapterTwo.setData(appState.moviesData)
                binding.progressBar.visibility = View.GONE
            }
            is AppState.Error -> {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                binding.progressBar.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        adapterOne.removeListener()
    }
}