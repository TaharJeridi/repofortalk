package it.wakala.talkrepo.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import it.wakala.talkrepo.base.ABaseFragment
import it.wakala.talkrepo.databinding.HomeFragmentBinding
import it.wakala.talkrepo.entity.MarvelCharsEntity
import it.wakala.talkrepo.entity.ResultEntity
import it.wakala.talkrepo.ui.adapter.MarvelCharactersListAdapter
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
    private var isLatestElementVisible = false
    private var isFirstStartFailed = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            marvelCharactersList.adapter = mAdapter
            marvelCharactersList.addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy > 0) {
                        val layoutManager = marvelCharactersList.layoutManager as GridLayoutManager
                        val visibleItemCount = layoutManager.findLastCompletelyVisibleItemPosition() + 1
                        if (visibleItemCount == layoutManager.itemCount && !isLoading) {
                            isLatestElementVisible = true
                            marvelCharactersViewModel.getMarvelCharactersList(true)
                        }else{
                            isLatestElementVisible = false
                        }
                    }
                }
            })

        }

        marvelCharactersViewModel.marvelCharactersLiveData.observe(viewLifecycleOwner) {
            if (it.isSuccess) {
                val marvelChars = it.getOrNull()
                mAdapter.data = marvelChars?.data?.results?.toMutableList() ?: mutableListOf()
            } else {
                Timber.e(it.exceptionOrNull())
            }
        }
        marvelCharactersViewModel.getMarvelCharactersList()

    }

}