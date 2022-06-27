package it.wakala.talkrepo

fun String?.notNullOrEmpty(): String {
    this?.let {
        return this
    } ?: kotlin.run {
        return ""
    }
}