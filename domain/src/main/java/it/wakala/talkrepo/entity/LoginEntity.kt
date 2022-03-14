package it.wakala.talkrepo.entity

data class LoginEntity(
    val publicKey: String,
    val privateKey: String,
    val mail: String
)