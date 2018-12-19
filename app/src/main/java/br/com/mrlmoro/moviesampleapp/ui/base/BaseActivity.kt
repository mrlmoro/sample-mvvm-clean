package br.com.mrlmoro.moviesampleapp.ui.base

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by Murilo Moro on 20/11/18.
 */
abstract class BaseActivity<B : ViewDataBinding, V : BaseViewModel> : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    val viewModel: V by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(viewModelClass())
    }

    lateinit var binding: B

    protected abstract fun layout(): Int

    protected abstract fun viewModelClass(): Class<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layout())

    }

}