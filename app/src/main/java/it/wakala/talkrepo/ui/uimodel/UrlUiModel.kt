package it.wakala.talkrepo.ui.uimodel

import it.wakala.talkrepo.entity.UrlEntity

data class UrlUiModel(
    val type: String,
    val url: String
)

fun UrlEntity.toUiModel() = UrlUiModel(type, url)