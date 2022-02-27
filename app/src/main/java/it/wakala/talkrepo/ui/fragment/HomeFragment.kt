package it.wakala.talkrepo.ui.fragment

import it.wakala.talkrepo.base.ABaseFragment
import it.wakala.talkrepo.databinding.HomeFragmentBinding

class HomeFragment : ABaseFragment<HomeFragmentBinding>() {

    override fun setBinding(): HomeFragmentBinding {
        return HomeFragmentBinding.inflate(layoutInflater)
    }

}