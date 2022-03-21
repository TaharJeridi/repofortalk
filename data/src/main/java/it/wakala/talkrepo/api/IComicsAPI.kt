package it.wakala.talkrepo.api

import it.wakala.talkrepo.response.comics.ComicsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IComicsAPI {

    @GET("/v1/public/comics")
    suspend fun getMarvelComics(@Query("offset") offset: Int): ComicsResponse?

}