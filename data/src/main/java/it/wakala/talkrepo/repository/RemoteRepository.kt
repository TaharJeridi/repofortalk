package it.wakala.talkrepo.repository

import it.wakala.talkrepo.entity.MarvelCharsEntity


interface RemoteRepository {

    suspend fun getAllCharacters(offset: Int): MarvelCharsEntity

}