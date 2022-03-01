package it.wakala.talkrepo.ui.activity

import dagger.hilt.android.AndroidEntryPoint
import android.os.Bundle
import it.wakala.talkrepo.base.ABaseActivity
import it.wakala.talkrepo.databinding.ActivityMainBinding
import it.wakala.talkrepo.extension.setUpNavController

@AndroidEntryPoint
class MainActivity : ABaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpNavController(binding.navView)
    }

    override fun setBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

}