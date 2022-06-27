package it.wakala.talkrepo.ui.uimodel

data class InputValidationUiModel(
    val message: String,
    val errorField: ErrorField
)

enum class ErrorField {
    NAME,
    SURNAME,
    MAIL,
}