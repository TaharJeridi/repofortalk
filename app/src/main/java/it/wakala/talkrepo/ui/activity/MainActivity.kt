package it.wakala.talkrepo.ui.activity

import android.content.Context
import android.content.Intent
import dagger.hilt.android.AndroidEntryPoint
import android.os.Bundle
import it.wakala.talkrepo.R
import it.wakala.talkrepo.base.ABaseActivity
import it.wakala.talkrepo.databinding.ActivityMainBinding
import it.wakala.talkrepo.extension.setUpNavController
import it.wakala.talkrepo.utils.extension.setStatusBarColor

@AndroidEntryPoint
class MainActivity : ABaseActivity<ActivityMainBinding>() {

    companion object {
        fun startActivity(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColor(R.color.marvel_blu)
        setUpNavController(binding.navView)
    }

    override fun setBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

}