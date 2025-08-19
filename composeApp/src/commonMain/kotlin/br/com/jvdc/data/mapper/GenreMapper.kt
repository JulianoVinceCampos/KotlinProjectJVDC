package br.com.jvdc.data.mapper

import br.com.jvdc.data.network.model.GenreResponse
import br.com.jvdc.domain.model.Genre

fun GenreResponse.toModel() = Genre(
    id = this.id,
    name = this.name,
)