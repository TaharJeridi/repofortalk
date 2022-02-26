package it.wakala.talkrepo.repositories

import it.wakala.talkrepo.entity.MarvelCharsEntity


interface RemoteRepository {

    suspend fun getAllCharacters(): MarvelCharsEntity

}