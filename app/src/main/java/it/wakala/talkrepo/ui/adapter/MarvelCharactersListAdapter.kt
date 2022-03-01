package it.wakala.talkrepo.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import it.wakala.talkrepo.databinding.ItemViewLoadingBinding
import it.wakala.talkrepo.databinding.ItemViewMarvelCharacterBinding
import it.wakala.talkrepo.entity.ResultEntity
import it.wakala.talkrepo.ui.state.Loading
import it.wakala.talkrepo.ui.uimodel.MarvelCharactersResult
import it.wakala.talkrepo.ui.uimodel.ResultLoadingUiModel
import it.wakala.talkrepo.ui.uimodel.ResultUiModel

class MarvelCharactersListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val LOADING = 0
        const val DATA = 1
    }

    var data: MutableList<MarvelCharactersResult> = mutableListOf()
    @SuppressLint("NotifyDataSetChanged")
    set(value) {
        field.addAll(value)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when(viewType) {
            LOADING -> {
                val binding = ItemViewLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                LoadingViewHolder(binding)
            }
            else -> {
                val binding = ItemViewMarvelCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                MarvelCharactersViewHolder(binding)
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder) {
            is MarvelCharactersViewHolder -> holder.render(data[position])
            else -> (holder as? LoadingViewHolder)?.render()
        }


    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addLoading() {
        data.add(ResultLoadingUiModel)
    }

    fun removeLoading() {
        data.removeAll {it is ResultLoadingUiModel}
    }

    override fun getItemViewType(position: Int): Int {
        return when(data[position]) {
            is ResultLoadingUiModel -> {
                LOADING
            }
            else -> DATA
        }
    }

    inner class MarvelCharactersViewHolder(val binding: ItemViewMarvelCharacterBinding): RecyclerView.ViewHolder(binding.root) {
        fun render(value: MarvelCharactersResult) {
            with(binding) {
                Glide.with(heroIv)
                    .load("${value.thumbnail?.path}.${value.thumbnail?.extension}")
                    .circleCrop()
                    .into(heroIv)

                heroNameTv.text = value.name?.replaceFirstChar { it.uppercase() }
            }
        }
    }

    inner class LoadingViewHolder(private val binding: ItemViewLoadingBinding): RecyclerView.ViewHolder(binding.root) {
        fun render() {
            with(binding) {
                loadingContainer.startShimmer()
            }
        }
    }
}