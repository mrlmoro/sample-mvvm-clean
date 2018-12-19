package br.com.mrlmoro.moviesampleapp.domain.model

/**
 * Created by Murilo Moro on 20/11/18.
 */
data class Movie(
    val id: Long,
    val title: String,
    val rate: Int,
    val imageUrl: String
)