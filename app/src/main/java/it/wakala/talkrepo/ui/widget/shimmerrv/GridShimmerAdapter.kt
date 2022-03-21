package it.wakala.talkrepo.ui.widget.shimmerrv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import it.wakala.talkrepo.databinding.ItemShimmerBinding

class GridShimmerAdapter : RecyclerView.Adapter<GridShimmerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridShimmerViewHolder {
        return GridShimmerViewHolder(
            ItemShimmerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: GridShimmerViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }
}