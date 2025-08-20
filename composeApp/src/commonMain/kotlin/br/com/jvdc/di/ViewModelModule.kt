package br.com.jvdc.di

import br.com.jvdc.ui.moviedetail.MovieDetailViewModel
import br.com.jvdc.ui.movies.MoviesListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule= module{
    viewModel { MoviesListViewModel(get()) }
    viewModel { MovieDetailViewModel(get(), get()) }
}