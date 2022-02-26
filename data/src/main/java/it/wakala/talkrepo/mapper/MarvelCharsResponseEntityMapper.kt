package it.wakala.talkrepo.mapper

import it.wakala.talkrepo.base.Mapper
import it.wakala.talkrepo.entity.MarvelCharsEntity
import it.wakala.talkrepo.response.MarvelCharsResponse
import javax.inject.Inject

class MarvelCharsResponseEntityMapper @Inject constructor(
 private val marvelDataResponseEntityMapper: MarvelDataResponseEntityMapper
): Mapper<MarvelCharsResponse, MarvelCharsEntity, Any>() {


    override fun mapToEntity(input: MarvelCharsResponse): MarvelCharsEntity = MarvelCharsEntity(
        attributionHTML = input.attributionHTML,
        attributionText = input.attributionText,
        code = input.code,
        copyright = input.copyright,
        etag = input.etag,
        status = input.status,
        data = marvelDataResponseEntityMapper.mapToEntity(input.data)
    )

}