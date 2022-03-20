package it.wakala.talkrepo.ui.uimodel

import it.wakala.talkrepo.entity.LoginEntity

data class LoginUiModel(
    val publicKey: String,
    val privateKey: String,
    val mail: String
)

fun LoginEntity.toUiModel() = LoginUiModel(publicKey, privateKey, mail)