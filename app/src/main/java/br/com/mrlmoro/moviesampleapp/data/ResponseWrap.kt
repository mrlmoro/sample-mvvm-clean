package br.com.mrlmoro.moviesampleapp.data

/**
 * Created by Murilo Moro on 20/11/18.
 */
data class ResponseWrap<T>(val results: List<T> = arrayListOf())