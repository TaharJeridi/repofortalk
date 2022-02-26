package it.wakala.talkrepo.ui.activity

import android.os.Bundle
import it.wakala.talkrepo.base.ABaseActivity
import it.wakala.talkrepo.databinding.ActivityMainBinding
import it.wakala.talkrepo.extension.setUpNavController

class MainActivity : ABaseActivity<ActivityMainBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpNavController(binding.navView)
    }

    override fun setBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


}