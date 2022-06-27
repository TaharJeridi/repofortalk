package it.wakala.talkrepo.utils.extension

import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import it.wakala.talkrepo.LogHelper

fun FragmentActivity.setStatusBarColor(@ColorRes color: Int) {
    try {
        if (color != 0) {
            window.statusBarColor = ContextCompat.getColor(this, color)
        }
    } catch (e: Throwable) {
        LogHelper.printStackTrace(FragmentActivity::class.java.name, e)
    }

}