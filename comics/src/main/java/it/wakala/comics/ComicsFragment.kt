package it.wakala.comics

import it.wakala.comics.databinding.ComicsFragmentBinding
import it.wakala.talkrepo.base.ABaseFragment

class ComicsFragment : ABaseFragment<ComicsFragmentBinding>() {

    override fun setBinding(): ComicsFragmentBinding {
        return ComicsFragmentBinding.inflate(layoutInflater)
    }
}