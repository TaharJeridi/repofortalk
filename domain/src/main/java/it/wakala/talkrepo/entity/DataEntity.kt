package it.wakala.talkrepo.entity

data class DataEntity(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<ResultEntity>,
    val total: Int
)