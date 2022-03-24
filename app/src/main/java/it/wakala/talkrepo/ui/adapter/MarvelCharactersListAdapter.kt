package it.wakala.talkrepo.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import it.wakala.talkrepo.databinding.ItemViewLoadingBinding
import it.wakala.talkrepo.databinding.ItemViewMarvelCharacterBinding
import it.wakala.talkrepo.entity.ResultEntity
import it.wakala.talkrepo.modelview.ComicsModelView
import it.wakala.talkrepo.ui.state.Loading
import it.wakala.talkrepo.ui.uimodel.MarvelCharactersResult
import it.wakala.talkrepo.ui.uimodel.ResultLoadingUiModel
import it.wakala.talkrepo.ui.uimodel.ResultUiModel

class MarvelCharactersListAdapter: PagingDataAdapter<MarvelCharactersResult, RecyclerView.ViewHolder>(diffCallback) {

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<MarvelCharactersResult>() {
            override fun areItemsTheSame(
                oldItem: MarvelCharactersResult,
                newItem: MarvelCharactersResult
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: MarvelCharactersResult,
                newItem: MarvelCharactersResult
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemViewMarvelCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
       return  MarvelCharactersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MarvelCharactersViewHolder).render(getItem(position))
    }

    inner class MarvelCharactersViewHolder(val binding: ItemViewMarvelCharacterBinding): RecyclerView.ViewHolder(binding.root) {
        fun render(value: MarvelCharactersResult?) {
            with(binding) {
                Glide.with(heroIv)
                    .load("${value?.thumbnail?.path}.${value?.thumbnail?.extension}")
                    .circleCrop()
                    .into(heroIv)

                heroNameTv.text = value?.name?.replaceFirstChar { it.uppercase() }
            }
        }
    }
}