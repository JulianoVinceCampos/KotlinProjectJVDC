package br.com.jvdc.di

import br.com.jvdc.data.network.KtorClient
import br.com.jvdc.data.repository.MoviesRepository
import org.koin.dsl.module

val networkModule = module {
    single { KtorClient() }
    single { MoviesRepository(get(), get()) }
}