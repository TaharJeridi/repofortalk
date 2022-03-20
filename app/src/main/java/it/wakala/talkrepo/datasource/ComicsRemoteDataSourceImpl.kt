package it.wakala.talkrepo.datasource

import it.wakala.talkrepo.api.IComicsAPI
import it.wakala.talkrepo.response.comics.ComicsResponse
import javax.inject.Inject


class ComicsRemoteDataSourceImpl @Inject constructor(
    private val comicsAPI: IComicsAPI
) : ComicsRemoteDataSource {


    override suspend fun getMarvelComics(): ComicsResponse? {
        return comicsAPI.getMarvelComics()
    }

}