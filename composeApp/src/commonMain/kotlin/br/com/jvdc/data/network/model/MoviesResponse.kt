package br.com.jvdc.data.network.model

import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviesListResponse(
    val results: List<MovieResponse>,
)

@Serializable
data class MovieResponse(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String,
    val genres: List<GenreResponse>? = null,
    @SerialName("release_date")
    val releaseData:LocalDate,
    val runtime: Int? = null,
    @SerialName("vote_average")
    val voteAverage: Double,
)

@Serializable
data class GenreResponse(
    val id:Int,
    val name: String,
)