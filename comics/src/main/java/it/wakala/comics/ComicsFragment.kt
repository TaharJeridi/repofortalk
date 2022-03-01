package it.wakala.comics

import android.os.Bundle
import android.view.View
import it.wakala.comics.databinding.ComicsFragmentBinding
import it.wakala.talkrepo.base.ABaseFragment
import it.wakala.talkrepo.marvelViewModels


class ComicsFragment : ABaseFragment<ComicsFragmentBinding>() {

    private val comicsViewModel by marvelViewModels<ComicsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        comicsViewModel.fetchComics()
    }

    override fun setBinding(): ComicsFragmentBinding {
        return ComicsFragmentBinding.inflate(layoutInflater)
    }
}