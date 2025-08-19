package br.com.jvdc.data.mapper

import br.com.jvdc.data.network.IMAGE_BASE_URL
import br.com.jvdc.data.network.model.CastMemberResponse
import br.com.jvdc.domain.model.CastMember
import br.com.jvdc.domain.model.ImageSize

fun CastMemberResponse.toModel() = CastMember(
    id = this.id,
    mainRole = this.department,
    name = this.name,
    character = this.character,
    profileUrl = "$IMAGE_BASE_URL/${ImageSize.X_SMALL.size}/${this.profilePath}",
)