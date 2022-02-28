package it.wakala.talkrepo.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import it.wakala.talkrepo.base.ABaseFragment
import it.wakala.talkrepo.databinding.HomeFragmentBinding
import it.wakala.talkrepo.ui.viewmodel.MarvelCharactersViewModel
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : ABaseFragment<HomeFragmentBinding>() {

    private val marvelCharactersViewModel: MarvelCharactersViewModel by viewModels()

    override fun setBinding(): HomeFragmentBinding {
        return HomeFragmentBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        marvelCharactersViewModel.marvelCharactersLiveData.observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                val marvelChars = it.getOrNull()
            } else {
                Timber.e(it.exceptionOrNull())
            }
        }
        marvelCharactersViewModel.getMarvelCharactersList()

    }

}