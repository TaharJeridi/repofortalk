package it.wakala.talkrepo.api

import it.wakala.talkrepo.response.MarvelCharsResponse
import retrofit2.http.GET

interface RemoteApi {

    @GET
    suspend fun getMarvelCharacters(): MarvelCharsResponse

}