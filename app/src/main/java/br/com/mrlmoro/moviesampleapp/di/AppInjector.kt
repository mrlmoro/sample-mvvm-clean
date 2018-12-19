package br.com.mrlmoro.moviesampleapp.di

import br.com.mrlmoro.moviesampleapp.MovieApp

object AppInjector {

    fun init(app: MovieApp) {
        DaggerAppComponent.builder()
            .application(app)
            .build()
            .inject(app)
    }
}