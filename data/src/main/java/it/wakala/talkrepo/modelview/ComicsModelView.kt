package it.wakala.talkrepo.modelview

import java.io.Serializable

data class ComicsModelView(
    var id: Int? = null,
    var digitalId: Int? = null,
    var title: String? = null,
    var variantDescription: String? = null,
    var description: String? = null,
    var pageCount: Int? = null,
    var resourceURI: String? = null,
) : Serializable