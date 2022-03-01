package it.wakala.talkrepo.ui.uimodel

import it.wakala.talkrepo.entity.DataEntity
import it.wakala.talkrepo.entity.MarvelCharsEntity

data class DataUiModel(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultUiModel>,
    val total: Int
)

fun DataEntity.toUiModel() = DataUiModel(count, limit, offset, results.map { it.toUiModel() }, total)