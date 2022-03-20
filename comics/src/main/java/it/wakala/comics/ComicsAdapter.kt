package it.wakala.comics

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import it.wakala.comics.databinding.ItemComicsBinding
import it.wakala.talkrepo.modelview.ComicsModelView

class ComicsAdapter : RecyclerView.Adapter<ComicsViewHolder>() {

    companion object {

        const val SPAN_COUNT_COMICS = 3

    }

    private val comicsList: ArrayList<ComicsModelView> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun updateComicsList(newComicsList: ArrayList<ComicsModelView>) {
        this.comicsList.clear()
        this.comicsList.addAll(newComicsList)
        this.notifyDataSetChanged()
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

    override fun getItemCount(): Int {
        return comicsList.size
    }

    /*
     * private method
     */

    private fun getItem(position: Int): ComicsModelView {
        return comicsList[position]
    }
}