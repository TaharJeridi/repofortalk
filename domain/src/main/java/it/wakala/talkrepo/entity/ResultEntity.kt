package it.wakala.talkrepo.entity

data class ResultEntity(
    val description: String,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val thumbnail: ThumbnailEntity,
    val urls: List<UrlEntity>
)