package it.wakala.comics

import android.app.Application
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.paging.PagingData
import androidx.recyclerview.widget.GridLayoutManager
import it.wakala.comics.databinding.ComicsFragmentBinding
import it.wakala.talkrepo.usecase.ComicsUseCase
import it.wakala.talkrepo.MarvelViewModelFactory
import it.wakala.talkrepo.base.ABaseFragment
import it.wakala.talkrepo.modelview.ComicsModelView
import javax.inject.Inject


class ComicsFragment : ABaseFragment<ComicsFragmentBinding>() {

    @Inject
    lateinit var comicsUseCase: ComicsUseCase

    private val comicsAdapter by lazy { ComicsAdapter() }

    private val comicsViewModel by viewModels<ComicsViewModel> {
        MarvelViewModelFactory(
            requireContext().applicationContext as Application,
            comicsUseCase
        )
    }

    private val observerComics = Observer<PagingData<ComicsModelView>> {
        comicsAdapter.submitData(lifecycle, it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRVComics()

        comicsViewModel.fetchComics().observe(viewLifecycleOwner, observerComics)
    }

    override fun setBinding(): ComicsFragmentBinding {
        return ComicsFragmentBinding.inflate(layoutInflater)
    }

    /*
     * private method
     */

    private fun initRVComics() {
        binding.rvComics.apply {
            this.layoutManager = GridLayoutManager(context, ComicsAdapter.SPAN_COUNT_COMICS)
            this.adapter = comicsAdapter
        }
    }
}