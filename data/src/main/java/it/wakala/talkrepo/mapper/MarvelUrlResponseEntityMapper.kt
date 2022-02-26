package it.wakala.talkrepo.mapper

import it.wakala.talkrepo.base.Mapper
import it.wakala.talkrepo.entity.ThumbnailEntity
import it.wakala.talkrepo.entity.UrlEntity
import it.wakala.talkrepo.response.Thumbnail
import it.wakala.talkrepo.response.Url
import javax.inject.Inject

class MarvelUrlResponseEntityMapper @Inject constructor(

): Mapper<List<Url>, List<UrlEntity>, Any>() {

    override fun mapToEntity(input: List<Url>): List<UrlEntity> = input.map { urlDetail ->
        UrlEntity(
            type = urlDetail.type,
            url = urlDetail.url
        )
    }
}