package br.com.jvdc.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.jvdc.domain.model.movie1
import br.com.jvdc.ui.components.MoviePoster
import br.com.jvdc.ui.movies.MoviesListScreen

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    MoviePoster(
        movie = movie1
    )
}

@Preview(showBackground = true)
@Composable
private fun MovieListScreenPreview() {
    MoviesListScreen(
        popularMovies = listOf(movie1)
    )
}