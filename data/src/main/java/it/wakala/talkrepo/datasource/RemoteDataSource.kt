package it.wakala.talkrepo.datasource

import it.wakala.talkrepo.entity.MarvelCharsEntity


interface RemoteDataSource {
    suspend fun getMarvelCharacters(): MarvelCharsEntity
}