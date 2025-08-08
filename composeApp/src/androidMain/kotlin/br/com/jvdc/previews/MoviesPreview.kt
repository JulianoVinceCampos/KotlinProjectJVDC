package br.com.jvdc.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.jvdc.domain.model.MovieSection
import br.com.jvdc.domain.model.movie1
import br.com.jvdc.ui.components.MoviePoster
import br.com.jvdc.ui.movies.MoviesListScreen
import br.com.jvdc.ui.movies.MoviesListViewModel

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
        moviesListState = MoviesListViewModel.MoviesListState.Success(
            movieSections = listOf(
                MovieSection(
                    sectionType = MovieSection.SectionType.POPULAR,
                    movies = listOf(movie1)
                )
            )
        )
    )
}