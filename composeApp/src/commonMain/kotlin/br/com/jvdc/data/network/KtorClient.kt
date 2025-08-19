package br.com.jvdc.data.network

import br.com.jvdc.data.network.model.CreditsListResponse
import br.com.jvdc.data.network.model.MovieResponse
import br.com.jvdc.data.network.model.MoviesListResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://api.themoviedb.org"
const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p"

class KtorClient {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(
                        accessToken ="eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5Mjk1ZmY2N2NkYjIwYzdiMDY1MGQ4Y2ExM2ExZTU2NCIsIm5iZiI6MTc1NDc0ODQ4MC43MzcsInN1YiI6IjY4OTc1NjQwYTc2OTBhOGUwODZkNjNhMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.dWx69wTArEQMKtytsFUvboRP0BqCPL9GYhd8UsDxEJM",
                        refreshToken = ""
                    )
                }
            }
        }
        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
            sanitizeHeader { header -> header == HttpHeaders.Authorization }
        }
    }

    suspend fun getMovies(category: String): MoviesListResponse {
        return client.get("$BASE_URL/3/movie/$category") {
            addLanguageParam()
        }.body()
    }

    suspend fun getMovieDetail(movieId: Int): MovieResponse {
        return client.get("$BASE_URL/3/movie/$movieId") {
            addLanguageParam()
        }.body()
    }

    suspend fun getCredits(movieId: Int): CreditsListResponse {
        return client.get("$BASE_URL/3/movie/$movieId/credits") {
            addLanguageParam()
        }.body()
    }

    private fun HttpRequestBuilder.addLanguageParam(language: String = "pt-BR"){
        parameter("language", language)
    }
}
