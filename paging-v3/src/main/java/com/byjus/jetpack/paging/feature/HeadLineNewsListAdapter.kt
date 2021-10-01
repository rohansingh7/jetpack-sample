package com.byjus.jetpack.paging.feature

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.byjus.jetpack.paging.databinding.ItemHeadLinesBinding

class HeadLineNewsListAdapter(private val context: Context): PagingDataAdapter<HeadLineEntity, HeadLineItemViewHolder>(LibraryDiffUtil()) {
    override fun onBindViewHolder(holder: HeadLineItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadLineItemViewHolder {
        val binding = ItemHeadLinesBinding.inflate(LayoutInflater.from(context),parent, false)
        return HeadLineItemViewHolder(binding)
    }

    class LibraryDiffUtil : DiffUtil.ItemCallback<HeadLineEntity>() {
        override fun areContentsTheSame(oldItem: HeadLineEntity, newItem: HeadLineEntity): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(oldItem: HeadLineEntity, newItem: HeadLineEntity): Boolean {
            return oldItem == newItem
        }
    }

}