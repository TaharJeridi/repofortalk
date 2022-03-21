package it.wakala.talkrepo.ui.widget.shimmerrv

import androidx.recyclerview.widget.RecyclerView
import it.wakala.talkrepo.databinding.ItemShimmerBinding

class GridShimmerViewHolder(private val binding: ItemShimmerBinding):RecyclerView.ViewHolder(binding.root){

    fun bind(){
        binding.shimmerViewContainer.startShimmer()
    }
}