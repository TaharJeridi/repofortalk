package it.wakala.talkrepo.datasource

import it.wakala.talkrepo.api.RemoteApi
import it.wakala.talkrepo.datasource.RemoteDataSource
import it.wakala.talkrepo.entity.MarvelCharsEntity
import it.wakala.talkrepo.mapper.MarvelCharsResponseEntityMapper
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val remoteApi: RemoteApi,
    private val marvelCharsResponseEntityMapper: MarvelCharsResponseEntityMapper
) : RemoteDataSource {

    override suspend fun getMarvelCharacters(): MarvelCharsEntity {
        return marvelCharsResponseEntityMapper.mapToEntity(remoteApi.getMarvelCharacters())
    }
}