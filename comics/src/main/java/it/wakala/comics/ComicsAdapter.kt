package it.wakala.comics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import it.wakala.comics.databinding.ItemComicsBinding
import it.wakala.talkrepo.modelview.ComicsModelView

class ComicsAdapter : PagingDataAdapter<ComicsModelView, ComicsViewHolder>(diffCallback) {

    companion object {

        const val SPAN_COUNT_COMICS = 3

        val diffCallback = object : DiffUtil.ItemCallback<ComicsModelView>() {
            override fun areItemsTheSame(
                oldItem: ComicsModelView,
                newItem: ComicsModelView
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ComicsModelView,
                newItem: ComicsModelView
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        return ComicsViewHolder(
            ItemComicsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}