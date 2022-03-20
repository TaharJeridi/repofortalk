package it.wakala.talkrepo.repositories

import it.wakala.talkrepo.entity.LoginEntity
import it.wakala.talkrepo.entity.MarvelCharsEntity


interface LocalRepository {

    suspend fun login(mail: String, name: String, surname: String): LoginEntity

}