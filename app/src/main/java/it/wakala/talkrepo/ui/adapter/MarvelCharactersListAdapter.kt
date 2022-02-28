package it.wakala.talkrepo.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import it.wakala.talkrepo.databinding.ItemViewMarvelCharacterBinding
import it.wakala.talkrepo.entity.ResultEntity

class MarvelCharactersListAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var data: MutableList<ResultEntity> = mutableListOf()
    @SuppressLint("NotifyDataSetChanged")
    set(value) {
        field.addAll(value)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemViewMarvelCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarvelCharactersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? MarvelCharactersViewHolder)?.render(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MarvelCharactersViewHolder(val binding: ItemViewMarvelCharacterBinding): RecyclerView.ViewHolder(binding.root) {
        fun render(value: ResultEntity) {
            with(binding) {
                Glide.with(heroIv)
                    .load("${value.thumbnail.path}.${value.thumbnail.extension}")
                    .circleCrop()
                    .into(heroIv)

                heroNameTv.text = value.name.replaceFirstChar { it.uppercase() }
            }
        }
    }
}