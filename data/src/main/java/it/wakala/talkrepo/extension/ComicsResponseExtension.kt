package it.wakala.talkrepo.extension

import it.wakala.talkrepo.comics.ComicsEntity
import it.wakala.talkrepo.response.comics.ComicsResponse

fun ComicsResponse?.toComicsEntityList(): ArrayList<ComicsEntity> {
    val resultList = ArrayList<ComicsEntity>()
    this?.let { comicsResponse ->
        val comicsDataResponse = comicsResponse.data
        comicsDataResponse?.results?.let {
            for (comics in it) {
                resultList.add(
                    ComicsEntity(
                        comics.id,
                        comics.digitalId,
                        comics.title,
                        comics.variantDescription,
                        comics.description,
                        comics.pageCount,
                        comics.resourceURI,
                        comics.thumbnail?.path,
                        comics.thumbnail?.extension
                    )
                )
            }
        }
    }
    return resultList
}