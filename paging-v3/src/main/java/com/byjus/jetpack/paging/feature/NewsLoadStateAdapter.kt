package com.byjus.jetpack.paging.feature

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import timber.log.Timber
import java.util.*

private const val TAG = "PeopleLoadStateAdapter"
class NewsLoadStateAdapter(private val retry: () -> Unit): LoadStateAdapter<LoadStateViewHolder>() {
    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        Timber.d("$TAG onBindViewHolder")
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        Timber.d("$TAG onCreateViewHolder")
        return LoadStateViewHolder(parent, retry)
    }
}