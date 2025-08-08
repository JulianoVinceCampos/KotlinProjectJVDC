package br.com.jvdc.data.network

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
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://api.themoviedb.org"
const val IMAGE_SMALL_BASE_URL = "https://image.tmdb.org/t/p/w154"

object KtorClient {
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
                        accessToken ="eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4MGZlMjM4MzI2YmMzZmQxMTM0ZTBjNDY1MjU0ODhjMyIsIm5iZiI6MTYyOTcyNjMxNi40NTUwMDAyLCJzdWIiOiI2MTIzYTY2Y2Q2NTkwYjAwNDVhYTA1ZGUiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.VlCnW3f0OOdm-KTwU0dT_Q5dCJZy2jqRINYz_QRboco",
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

    suspend fun getMovies(category: String, language: String = "pt-BR"): MoviesListResponse {
        return client.get("$BASE_URL/3/movie/$category") {
            parameter("language", language)
        }.body()
    }
}
