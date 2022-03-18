package it.wakala.talkrepo.comics

import java.io.Serializable

data class ComicsEntity(
    var id: Int? = null,
    var digitalId: Int? = null,
    var title: String? = null,
    var variantDescription: String? = null,
    var description: String? = null,
    var pageCount: Int? = null,
    var resourceURI: String? = null
) : Serializable
