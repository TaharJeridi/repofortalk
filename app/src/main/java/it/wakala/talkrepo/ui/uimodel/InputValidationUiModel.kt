package it.wakala.talkrepo.ui.uimodel

data class InputValidationUiModel(
    val message: String,
    val errorField: ErrorField
)

enum class ErrorField(value: String) {
    NAME("NAME"),
    SURNAME("SURNAME"),
    MAIL("MAIL"),
}