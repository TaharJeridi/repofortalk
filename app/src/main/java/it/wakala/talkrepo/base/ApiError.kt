package it.wakala.talkrepo.base

data class ApiError(
    val statusCode: Int,
    val message: String
)