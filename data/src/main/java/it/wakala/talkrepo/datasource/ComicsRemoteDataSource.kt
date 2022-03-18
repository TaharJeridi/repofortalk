package it.wakala.talkrepo.datasource

import it.wakala.talkrepo.response.ComicsResponse


interface ComicsRemoteDataSource {

    suspend fun getMarvelComics(): ComicsResponse?

}