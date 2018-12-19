package br.com.mrlmoro.moviesampleapp.di.module

import br.com.mrlmoro.moviesampleapp.data.remote.MovieService
import br.com.mrlmoro.moviesampleapp.data.repository.MovieRepository
import br.com.mrlmoro.moviesampleapp.data.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Murilo Moro on 20/11/18.
 */
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(movieService: MovieService): MovieRepository {
        return MovieRepositoryImpl(movieService)
    }

}