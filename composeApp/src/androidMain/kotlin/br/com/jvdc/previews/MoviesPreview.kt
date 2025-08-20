package br.com.jvdc.previews

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.jvdc.domain.model.MovieSection
import br.com.jvdc.domain.model.movie1
import br.com.jvdc.ui.components.CastMemberItem
import br.com.jvdc.ui.components.MovieGenreChip
import br.com.jvdc.ui.components.MovieInfoItem
import br.com.jvdc.ui.components.MoviePoster
import br.com.jvdc.ui.moviedetail.MovieDetailScreen
import br.com.jvdc.ui.moviedetail.MovieDetailViewModel
import br.com.jvdc.ui.movies.MoviesListScreen
import br.com.jvdc.ui.movies.MoviesListViewModel
import br.com.jvdc.ui.theme.MoviesAppTheme
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Star

@Preview(showBackground = true)
@Composable
private fun MoviePosterPreview() {
    MoviePoster(
        movie = movie1,
        onMoviePosterClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun MovieListScreenPreview() {
    MoviesAppTheme {
        MoviesListScreen(
            moviesListState = MoviesListViewModel.MoviesListState.Success(
                movieSections = listOf(
                    MovieSection(
                        sectionType = MovieSection.SectionType.POPULAR,
                        movies = listOf(movie1)
                    )
                )
            ),
            onMovieClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MovieDetailScreenPreview() {
    MoviesAppTheme {
        MovieDetailScreen(
            movieDetailState = MovieDetailViewModel.MovieDetailState.Success(movie1),
            onNavigationIconClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MovieInfoItemPreview() {
    MoviesAppTheme {
        MovieInfoItem(
            icon = FontAwesomeIcons.Solid.Star,
            text = "8.5"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MovieGenreChipPreview() {
    MoviesAppTheme {
        MovieGenreChip(
            genre = "Action"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CastMemberItemPreview() {
    MoviesAppTheme {
        CastMemberItem(
            profilePictureUrl = "url",
            name = "Will Smith",
            character = "John Smith"
        )
    }
}