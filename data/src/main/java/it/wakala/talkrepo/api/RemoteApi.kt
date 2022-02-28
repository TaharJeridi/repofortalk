package it.wakala.talkrepo.api

import it.wakala.talkrepo.response.MarvelCharsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteApi {

    @GET("/v1/public/characters")
    suspend fun getMarvelCharacters(@Query("offset") offset: Int): MarvelCharsResponse

}