package br.com.mrlmoro.moviesampleapp.di

import android.app.Application
import br.com.mrlmoro.moviesampleapp.MovieApp
import br.com.mrlmoro.moviesampleapp.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        RepositoryModule::class,
        UseCaseModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MovieApp)
}