package it.wakala.talkrepo.mapper

import it.wakala.talkrepo.base.Mapper
import it.wakala.talkrepo.entity.ThumbnailEntity
import it.wakala.talkrepo.response.Thumbnail
import javax.inject.Inject

class MarvelThumbnailResponseEntityMapper @Inject constructor(

): Mapper<Thumbnail, ThumbnailEntity, Any>() {


    override fun mapToEntity(input: Thumbnail): ThumbnailEntity = ThumbnailEntity(
        extension = input.extension,
        path = input.path
    )

}