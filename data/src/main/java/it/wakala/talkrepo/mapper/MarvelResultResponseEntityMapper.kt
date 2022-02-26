package it.wakala.talkrepo.mapper

import it.wakala.talkrepo.base.Mapper
import it.wakala.talkrepo.entity.DataEntity
import it.wakala.talkrepo.entity.MarvelCharsEntity
import it.wakala.talkrepo.entity.ResultEntity
import it.wakala.talkrepo.response.Data
import it.wakala.talkrepo.response.MarvelCharsResponse
import it.wakala.talkrepo.response.Result
import javax.inject.Inject

class MarvelResultResponseEntityMapper @Inject constructor(
 private val marvelThumbnailResponseEntityMapper: MarvelThumbnailResponseEntityMapper,
 private val marvelUrlResponseEntityMapper: MarvelUrlResponseEntityMapper,
): Mapper<List<Result>, List<ResultEntity>, Any>() {


    override fun mapToEntity(input: List<Result>): List<ResultEntity> = input.map { result ->
       ResultEntity(
           description = result.description,
           id = result.id,
           modified = result.modified,
           name = result.name,
           resourceURI = result.resourceURI,
           thumbnail = marvelThumbnailResponseEntityMapper.mapToEntity(result.thumbnail),
            urls = marvelUrlResponseEntityMapper.mapToEntity(result.urls)
       )
    }

}