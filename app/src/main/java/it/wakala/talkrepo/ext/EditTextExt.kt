package it.wakala.talkrepo.ext

import android.widget.EditText

fun EditText.getStringText(): String {
    return this.text.toString()
}