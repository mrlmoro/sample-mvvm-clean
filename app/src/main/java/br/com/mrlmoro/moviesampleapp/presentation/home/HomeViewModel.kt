package br.com.mrlmoro.moviesampleapp.presentation.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import br.com.mrlmoro.moviesampleapp.domain.interactor.MovieUseCase
import br.com.mrlmoro.moviesampleapp.domain.model.Movie
import br.com.mrlmoro.moviesampleapp.ui.base.BaseViewModel
import javax.inject.Inject

/**
 * Created by Murilo Moro on 20/11/18.
 */
class HomeViewModel @Inject constructor(
    val movieUseCase: MovieUseCase
) : BaseViewModel() {

    private var page: Int = 1

    val movies = MutableLiveData<List<Movie>>()

    fun fetchMovie(): LiveData<List<Movie>> {
        fetch(
            movieUseCase.getPopularMovies(page),
            success = {
                movies.value = it
            }
        )

        return movies
    }

}