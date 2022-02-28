package it.wakala.talkrepo.ext

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


fun RecyclerView.gridPagination(callback: () -> Unit) {
    this.addOnScrollListener(object: RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager = this@gridPagination.layoutManager as GridLayoutManager
            val visibleItemCount = layoutManager.findLastCompletelyVisibleItemPosition() + 1
            if (visibleItemCount == layoutManager.itemCount) {
                callback.invoke()
            }
        }
    })
}