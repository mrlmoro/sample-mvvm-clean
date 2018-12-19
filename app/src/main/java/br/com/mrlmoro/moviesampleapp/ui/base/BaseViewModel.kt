package br.com.mrlmoro.moviesampleapp.ui.base

import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException

/**
 * Created by Murilo Moro on 20/11/18.
 */
abstract class BaseViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    protected fun <T> fetch(
        observable: Single<T>,
        success: ((T) -> Unit)? = null,
        error: ((HttpException) -> Unit)? = null
    ) {
        compositeDisposable.add(
            observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    success?.invoke(it)
                }, {
                    val e = (it as HttpException)
                    Log.i("ERROR_HTTPEXCEPTION", "code = ${e.code()}\nmessage = ${e.message()}\n")
                    Log.i("ERROR_HTTPEXCEPTION", "Error response = ${e.response().errorBody()?.string()}")

                    error?.invoke(e)
                })
        )

    }

    override fun onCleared() {
        compositeDisposable.clear()
    }

}