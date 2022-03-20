package it.wakala.comics

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import it.wakala.comics.databinding.ItemComicsBinding
import it.wakala.talkrepo.modelview.ComicsModelView

class ComicsViewHolder(private val itemComicsBinding: ItemComicsBinding) :
    RecyclerView.ViewHolder(itemComicsBinding.root) {

    fun bind(comicsModelView: ComicsModelView) {
        itemComicsBinding.tvComicsDescription.text = comicsModelView.title
        Glide.with(itemView.context).load(comicsModelView.thumbnailUri)
            .into(itemComicsBinding.ivThumbnailComics)

    }
}