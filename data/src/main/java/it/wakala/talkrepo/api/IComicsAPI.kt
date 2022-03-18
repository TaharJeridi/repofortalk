package it.wakala.talkrepo.api

import it.wakala.talkrepo.response.ComicsResponse
import retrofit2.http.GET

interface IComicsAPI {

    @GET("/v1/public/comics")
    suspend fun getMarvelComics(): ComicsResponse?

}