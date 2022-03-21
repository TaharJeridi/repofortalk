package it.wakala.talkrepo.ui.widget.shimmerrv

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.wakala.talkrepo.databinding.ShimmerContainerBinding

class ListShimmerContainer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding by lazy {
        ShimmerContainerBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )
    }

    init {
        initRvShimmerList()
    }


    override fun onFinishInflate() {
        super.onFinishInflate()
        children.forEach {
            if (it is RecyclerView) {
                it.addOnChildAttachStateChangeListener(object :RecyclerView.OnChildAttachStateChangeListener{
                    override fun onChildViewAttachedToWindow(view: View) {
                        binding.rvShimmer.visibility = View.GONE
                    }

                    override fun onChildViewDetachedFromWindow(view: View) {
                        //do nothing here
                    }
                })
            }
        }
    }


    private fun initRvShimmerList() {
        binding.rvShimmer.apply {
            this.adapter = GridShimmerAdapter()
            this.layoutManager = GridLayoutManager(context, 3)
        }
    }


}