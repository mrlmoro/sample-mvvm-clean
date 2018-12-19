package br.com.mrlmoro.moviesampleapp.di.module

import br.com.mrlmoro.moviesampleapp.presentation.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindHomeActivity(): HomeActivity

}