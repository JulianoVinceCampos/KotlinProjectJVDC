package br.com.jvdc.data.mapper

import br.com.jvdc.data.network.IMAGE_BASE_URL
import br.com.jvdc.data.network.model.CastMemberResponse
import br.com.jvdc.data.network.model.MovieResponse
import br.com.jvdc.domain.model.ImageSize
import br.com.jvdc.domain.model.Movie
import br.com.jvdc.utils.formatRating

fun MovieResponse.toModel(
    castMembersResponse: List<CastMemberResponse> ? = null,
    imageSize: ImageSize = ImageSize.SMALL
) = Movie(
    id = this.id,
    title = this.title,
    overview = this.overview,
    posterUrl = "$IMAGE_BASE_URL/${imageSize.size}/${this.posterPath}",
    genres = this.genres?.map { it.toModel() },
    year = this.getYearFromReleaseDate(),
    duration = this.getDurationInHoursAndMinutes(),
    rating = this.voteAverage.formatRating(),
    castMembers = castMembersResponse
        ?.filter { it.department == "Acting" }
        ?.take(20)
        ?.map { it.toModel() }
)

private fun MovieResponse.getYearFromReleaseDate(): Int {
    return this.releaseData.year
}

private fun MovieResponse.getDurationInHoursAndMinutes(): String? {
    return this.runtime?.let { runtimeMinutes ->
        val hours = runtimeMinutes / 60
        val minutes = runtimeMinutes % 60

        buildString {
            if (hours > 0) {
                append("${hours}h ")
            }

            append("${minutes}min")
        }
    }
}