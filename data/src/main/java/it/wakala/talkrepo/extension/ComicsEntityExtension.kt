package it.wakala.talkrepo.extension

import it.wakala.talkrepo.comics.ComicsEntity
import it.wakala.talkrepo.modelview.ComicsModelView

fun List<ComicsEntity>?.toComicsModelViewList(): List<ComicsModelView> {
    val resultList = ArrayList<ComicsModelView>()
    this?.let {
        for (comics in it) {
            resultList.add(
                ComicsModelView(
                    comics.id,
                    comics.digitalId,
                    comics.title,
                    comics.variantDescription,
                    comics.description,
                    comics.pageCount,
                    comics.resourceURI
                )
            )
        }
    }
    return resultList
}