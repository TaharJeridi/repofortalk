package it.wakala.talkrepo.ui.uimodel

import it.wakala.talkrepo.entity.MarvelCharsEntity


data class MarvelCharactersUiModel(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val data: DataUiModel,
    val etag: String,
    val status: String
)

fun MarvelCharsEntity.toUiModel() = MarvelCharactersUiModel(attributionHTML, attributionText, code, copyright, data.toUiModel(), etag, status)