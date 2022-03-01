package it.wakala.talkrepo.ui.uimodel

import it.wakala.talkrepo.entity.ThumbnailEntity

data class ThumbnailUiModel(
    val extension: String,
    val path: String
)

fun ThumbnailEntity.toUiModel() = ThumbnailUiModel(extension, path)