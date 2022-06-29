package it.wakala.talkrepo.extension

import it.wakala.talkrepo.database.ComicsTable
import it.wakala.talkrepo.entity.ComicsEntity
import it.wakala.talkrepo.modelview.ComicsModelView

fun List<ComicsTable>?.toComicsModelViewList(): ArrayList<ComicsModelView> {
    val resultList = ArrayList<ComicsModelView>()
    this?.let {
        for (comics in it) {
            resultList.add(
                ComicsModelView(
                    comics.idComics,
                    comics.digitalID,
                    comics.title,
                    comics.variantDescription,
                    comics.description,
                    comics.pageCount,
                    comics.resourceURI,
                    comics.thumbnailPath.plus(".").plus(comics.thumbnailExtension),
                )
            )
        }
    }
    return resultList
}

fun List<ComicsEntity>?.toComicsTableList(): ArrayList<ComicsTable> {
    val resultList = ArrayList<ComicsTable>()
    this?.let {
        for (comics in it) {
            resultList.add(
                ComicsTable().apply {
                    this.idComics = comics.id
                    this.digitalID = comics.digitalId
                    this.title = comics.title
                    this.variantDescription = comics.variantDescription
                    this.description = comics.description
                    this.pageCount = comics.pageCount
                    this.resourceURI = comics.resourceURI
                    this.thumbnailPath = comics.thumbnailPath
                    this.thumbnailExtension = comics.thumbnailExtension
                }
            )
        }
    }
    return resultList
}