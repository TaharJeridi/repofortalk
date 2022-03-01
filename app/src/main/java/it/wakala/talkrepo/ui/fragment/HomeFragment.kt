package it.wakala.talkrepo.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import it.wakala.talkrepo.base.ABaseFragment
import it.wakala.talkrepo.databinding.HomeFragmentBinding
import it.wakala.talkrepo.ext.gridPagination
import it.wakala.talkrepo.ui.adapter.MarvelCharactersListAdapter
import it.wakala.talkrepo.ui.state.Loading
import it.wakala.talkrepo.ui.state.Success
import it.wakala.talkrepo.ui.viewmodel.MarvelCharactersViewModel
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : ABaseFragment<HomeFragmentBinding>() {

    private val marvelCharactersViewModel: MarvelCharactersViewModel by viewModels()

    private val mAdapter: MarvelCharactersListAdapter by lazy { MarvelCharactersListAdapter() }

    override fun setBinding(): HomeFragmentBinding {
        return HomeFragmentBinding.inflate(layoutInflater)
    }

    private var isLoading = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            marvelCharactersList.adapter = mAdapter
            marvelCharactersList.gridPagination() {
                if(!isLoading) marvelCharactersViewModel.getMarvelCharactersList(true)
            }

        }

        marvelCharactersViewModel.marvelCharactersLiveData.observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                val marvelCharsResults = it.getOrNull() ?: return@observe
                when (marvelCharsResults) {
                    is Loading -> {
                        isLoading = true
                        mAdapter.addLoading()
                        binding.marvelCharactersList.smoothScrollToPosition(mAdapter.data.size - 1)
                    }
                    is Success -> {
                        isLoading = false
                        mAdapter.removeLoading()
                        mAdapter.data = marvelCharsResults.marvelCharactersResultUiModel.toMutableList()
                    }
                }

            } else {
                Timber.e(it.exceptionOrNull())
            }
        }
        marvelCharactersViewModel.getMarvelCharactersList()

    }

}