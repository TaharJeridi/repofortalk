package it.wakala.talkrepo.mapper

import it.wakala.talkrepo.base.Mapper
import it.wakala.talkrepo.entity.DataEntity
import it.wakala.talkrepo.entity.MarvelCharsEntity
import it.wakala.talkrepo.response.Data
import it.wakala.talkrepo.response.MarvelCharsResponse
import javax.inject.Inject

class MarvelDataResponseEntityMapper @Inject constructor(
    private val marvelResultResponseEntityMapper: MarvelResultResponseEntityMapper
): Mapper<Data, DataEntity, Any>() {

    override fun mapToEntity(input: Data): DataEntity = DataEntity(
        count = input.count,
        limit = input.limit,
        offset = input.offset,
        results = marvelResultResponseEntityMapper.mapToEntity(input.results),
        total = input.total
    )

}