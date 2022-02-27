package it.wakala.talkrepo.ui.activity

import it.wakala.talkrepo.base.ABaseActivity
import it.wakala.talkrepo.databinding.ActivityMainBinding

class MainActivity : ABaseActivity<ActivityMainBinding>() {

    override fun setBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


}