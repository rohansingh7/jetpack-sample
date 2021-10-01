package com.byjus.jetpack.paging.feature

import androidx.recyclerview.widget.RecyclerView
import com.byjus.jetpack.base.extensions.load
import com.byjus.jetpack.paging.DateUtils
import com.byjus.jetpack.paging.databinding.ItemHeadLinesBinding

class HeadLineItemViewHolder(private val binding: ItemHeadLinesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(entity: HeadLineEntity?) {
        with(binding) {
            entity?.let {  headLineEntity ->
                    txtDate.text = DateUtils.getPublishedDate(headLineEntity.publishedAt)
                    image.load(headLineEntity.urlToImage)
                    txtSource.text = DateUtils.getPublishedDate(headLineEntity.source)
                    txtTitle.text = DateUtils.getPublishedDate(headLineEntity.title)
            }
        }
    }
}