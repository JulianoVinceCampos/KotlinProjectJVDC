package br.com.jvdc.ui.moviedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import br.com.jvdc.data.repository.MoviesRepository
import br.com.jvdc.domain.model.Movie
import br.com.jvdc.navigation.AppRoutes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val moviesRepository: MoviesRepository,
) : ViewModel() {

    private val movieDetailRoute = savedStateHandle.toRoute<AppRoutes.MovieDetail>()

    private val _movieDetailState = MutableStateFlow<MovieDetailState>(MovieDetailState.Loading)
    val movieDetailState = _movieDetailState.asStateFlow()

    init {
        getMovieDetail()
    }

    private fun getMovieDetail() {
        viewModelScope.launch {
            moviesRepository.getMovieDetail(movieDetailRoute.id).fold(
                onSuccess = { movie ->
                    _movieDetailState.update {
                        MovieDetailState.Success(movie)
                    }
                },
                onFailure = { error ->
                    _movieDetailState.update {
                        MovieDetailState.Error(error.message ?: "Unknown error")
                    }
                })
        }
    }

    sealed interface MovieDetailState {
        data object Loading : MovieDetailState
        data class Success(val movie: Movie) : MovieDetailState
        data class Error(val message: String) : MovieDetailState
    }

}