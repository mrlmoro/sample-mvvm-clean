package br.com.mrlmoro.moviesampleapp.domain.interactor

import br.com.mrlmoro.moviesampleapp.data.repository.MovieRepository
import br.com.mrlmoro.moviesampleapp.domain.model.Movie
import io.reactivex.Single

/**
 * Created by Murilo Moro on 20/11/18.
 */
class MovieUseCase(
    private val movieRepository: MovieRepository
) {

    companion object {
        const val POSTER_HOST = "https://image.tmdb.org/t/p/w500"
    }

    fun getPopularMovies(page: Int): Single<List<Movie>> {
        return movieRepository.getPopularMovies(page)
            .flattenAsObservable { it }
            .map {
                Movie(
                    it.id,
                    it.title,
                    it.voteAverage.div(2).toInt(),
                    POSTER_HOST + it.posterPath
                )
            }
            .toList()
    }
}