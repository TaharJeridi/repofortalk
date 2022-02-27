package it.wakala.talkrepo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class ABaseActivity<T : ViewBinding> : AppCompatActivity() {

    val binding: T by lazy { setBinding() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    /*
    * abstract method
    */

    abstract fun setBinding(): T
}