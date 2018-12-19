package br.com.mrlmoro.moviesampleapp

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.Observer
import br.com.mrlmoro.moviesampleapp.data.model.MovieResponse
import br.com.mrlmoro.moviesampleapp.data.repository.MovieRepository
import br.com.mrlmoro.moviesampleapp.domain.interactor.MovieUseCase
import br.com.mrlmoro.moviesampleapp.domain.model.Movie
import br.com.mrlmoro.moviesampleapp.presentation.home.HomeViewModel
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

/**
 * Created by Murilo Moro on 21/11/18.
 */
class HomeViewModelTest {

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var movieRepository: MovieRepository

    @Mock
    lateinit var observer: Observer<List<Movie>>

    lateinit var viewModel: HomeViewModel

    @Before
    fun `Setup Test`() {
        MockitoAnnotations.initMocks(this)

        //ViewModel observeOn Android main thread so we change it to testable scheduler
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

        viewModel = HomeViewModel(MovieUseCase(movieRepository))
    }

    @Test
    fun `Test fetch popular movies`() {
        //Mock repository data
        val mockResponse = MovieResponse(1, "Filme", 8.0, "/path")
        val mockResponseList = arrayListOf(
            mockResponse,
            mockResponse.copy(id = 2, title = "Filme 2", voteAverage = 5.0)
        )
        doReturn(Single.just(mockResponseList)).`when`(movieRepository).getPopularMovies(1)


        //Mock to expected data after pass to UseCase
        val mock = Movie(1, "Filme", 4, "https://image.tmdb.org/t/p/w500/path")
        val mockList = arrayListOf(
            mock,
            mock.copy(id = 2, title = "Filme 2", rate = 2)
        )

        viewModel.movies.observeForever(observer)
        viewModel.fetchMovie()

        verify(observer).onChanged(mockList)
    }

}