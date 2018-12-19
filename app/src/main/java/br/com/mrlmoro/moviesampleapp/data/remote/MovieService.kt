package br.com.mrlmoro.moviesampleapp.data.remote

import br.com.mrlmoro.moviesampleapp.data.ResponseWrap
import br.com.mrlmoro.moviesampleapp.data.model.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Murilo Moro on 20/11/18.
 */
interface MovieService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("page") page: Int): Single<ResponseWrap<MovieResponse>>
}