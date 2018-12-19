package br.com.mrlmoro.moviesampleapp.di.module

import br.com.mrlmoro.moviesampleapp.data.repository.MovieRepository
import br.com.mrlmoro.moviesampleapp.domain.interactor.MovieUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Murilo Moro on 20/11/18.
 */
@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideMovieUseCase(movieRepository: MovieRepository): MovieUseCase {
        return MovieUseCase(movieRepository)
    }

}