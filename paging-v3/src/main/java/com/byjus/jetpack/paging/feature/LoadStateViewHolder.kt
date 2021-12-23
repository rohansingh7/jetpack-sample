package com.byjus.jetpack.paging.feature

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.byjus.jetpack.base.extensions.hide
import com.byjus.jetpack.base.extensions.show
import com.byjus.jetpack.paging.R
import com.byjus.jetpack.paging.databinding.LoadStateItemBinding
import timber.log.Timber

private const val TAG = "LoadStateViewHolder"
class LoadStateViewHolder(
    parent: ViewGroup,
    retry: () -> Unit
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(R.layout.load_state_item, parent, false)
) {

    private val binding = LoadStateItemBinding.bind(itemView)
    private val progressBar: CardView = binding.loader
    private val errorView: LottieAnimationView = binding.errorView
    fun bind(loadState: LoadState) {
        Timber.d("$TAG $loadState")
        when (loadState) {
            is LoadState.Error -> {
                errorView.show()
                progressBar.hide()
            }
            is LoadState.Loading -> {
                progressBar.show()
                errorView.hide()
            }
            else -> {
                progressBar.hide()
                errorView.hide()
            }
        }
    }
}