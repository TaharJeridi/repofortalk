package it.wakala.comics

import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import it.wakala.comics.databinding.ComicsFragmentBinding
import it.wakala.talkrepo.MarvelViewModelFactory
import it.wakala.talkrepo.base.ABaseFragment
import it.wakala.talkrepo.base.comics.ComicsUseCase
import javax.inject.Inject


class ComicsFragment : ABaseFragment<ComicsFragmentBinding>() {

    @Inject
    lateinit var comicsUseCase: ComicsUseCase

    private val comicsViewModel by viewModels<ComicsViewModel> {
        MarvelViewModelFactory(
            requireContext().applicationContext as Application,
            comicsUseCase
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        comicsViewModel.fetchComics()

    }

    override fun setBinding(): ComicsFragmentBinding {
        return ComicsFragmentBinding.inflate(layoutInflater)
    }
}