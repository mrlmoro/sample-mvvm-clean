package br.com.mrlmoro.moviesampleapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Murilo Moro on 20/11/18.
 */
data class MovieResponse(
    val id: Long,
    val title: String,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("poster_path") val posterPath: String
)