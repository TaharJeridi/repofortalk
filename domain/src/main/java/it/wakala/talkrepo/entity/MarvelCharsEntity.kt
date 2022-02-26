package it.wakala.talkrepo.entity

data class MarvelCharsEntity(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val data: DataEntity,
    val etag: String,
    val status: String
)