package it.wakala.talkrepo.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import it.wakala.talkrepo.LogHelper
import it.wakala.talkrepo.base.ABaseFragment
import it.wakala.talkrepo.databinding.HomeFragmentBinding
import it.wakala.talkrepo.notNullOrEmpty
import it.wakala.talkrepo.ui.adapter.MarvelCharactersListAdapter
import it.wakala.talkrepo.ui.viewmodel.MarvelCharactersViewModel

@AndroidEntryPoint
class HomeFragment : ABaseFragment<HomeFragmentBinding>() {

    private val marvelCharactersViewModel: MarvelCharactersViewModel by viewModels()

    private val mAdapter: MarvelCharactersListAdapter by lazy { MarvelCharactersListAdapter() }

    override fun setBinding(): HomeFragmentBinding {
        return HomeFragmentBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            marvelCharactersList.adapter = mAdapter
        }

        marvelCharactersViewModel.errorLiveData.observe(viewLifecycleOwner) {
            LogHelper.e(HomeFragment::class.java.name,it.error.message.notNullOrEmpty())
        }

        marvelCharactersViewModel.fetchMarvelCharactersList().observe(viewLifecycleOwner) {
            mAdapter.submitData(lifecycle, it)
        }

    }

}