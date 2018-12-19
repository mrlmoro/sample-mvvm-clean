package br.com.mrlmoro.moviesampleapp.data.repository

import br.com.mrlmoro.moviesampleapp.data.model.MovieResponse
import br.com.mrlmoro.moviesampleapp.data.remote.MovieService
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Created by Murilo Moro on 20/11/18.
 */

interface MovieRepository {
    fun getPopularMovies(page: Int): Single<List<MovieResponse>>
}

class MovieRepositoryImpl(
    private val service: MovieService
) : MovieRepository {

    override fun getPopularMovies(page: Int): Single<List<MovieResponse>> {
        //TODO create a cache here
        return service.getPopularMovies(page)
            .subscribeOn(Schedulers.io())
            .map { it.results }
    }

}