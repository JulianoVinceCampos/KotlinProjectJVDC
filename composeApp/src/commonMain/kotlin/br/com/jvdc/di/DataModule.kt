package br.com.jvdc.di

import br.com.jvdc.data.repository.MoviesRepository
import org.koin.dsl.module

val dataModule = module{
    factory { MoviesRepository(get()) }
}