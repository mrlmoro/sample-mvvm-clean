package br.com.mrlmoro.moviesampleapp.presentation.home

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import br.com.mrlmoro.moviesampleapp.R
import br.com.mrlmoro.moviesampleapp.databinding.ActivityHomeBinding
import br.com.mrlmoro.moviesampleapp.ui.base.BaseActivity

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    override fun layout(): Int = R.layout.activity_home

    override fun viewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.fetchMovie().observe(this, Observer {
            Log.i("HomeActivity", "Observer success list size = " + it?.size)
        })
    }
}
