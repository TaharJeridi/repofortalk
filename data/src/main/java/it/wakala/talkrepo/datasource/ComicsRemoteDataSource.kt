package it.wakala.talkrepo.datasource

import it.wakala.talkrepo.response.comics.ComicsResponse


interface ComicsRemoteDataSource {

    suspend fun getMarvelComics(): ComicsResponse?

}