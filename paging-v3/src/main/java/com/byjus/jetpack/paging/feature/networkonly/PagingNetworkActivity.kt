package com.byjus.jetpack.paging.feature.networkonly

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.byjus.jetpack.base.extensions.hide
import com.byjus.jetpack.base.extensions.show
import com.byjus.jetpack.paging.databinding.ActivityPageListBinding
import com.byjus.jetpack.paging.feature.PagingViewModel
import com.byjus.jetpack.paging.feature.HeadLineNewsListAdapter
import com.byjus.jetpack.paging.feature.NewsLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class PagingNetworkActivity : AppCompatActivity() {

    lateinit var binding: ActivityPageListBinding
    private val pagedViewModel: PagingViewModel by viewModels()
    private var pagingAdapter: HeadLineNewsListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
        observeFlowStream()
    }

    private fun observeFlowStream() {

        lifecycleScope.launch {
            pagingAdapter?.loadStateFlow?.collectLatest { loadStates ->
                val state = loadStates.refresh
                Timber.e("$TAG $state")
                when (state) {
                    is LoadState.Error -> {
                        binding.errorView.show()
                        binding.loader.hide()
                    }
                    is LoadState.Loading -> {
                        binding.loader.show()
                        binding.errorView.hide()
                    }
                    else -> {
                        binding.loader.hide()
                    }
                }
            }
        }


        lifecycleScope.launch {
            pagedViewModel.flow.collectLatest { pagingData ->
                Timber.e("pagingData = $pagingData")
                pagingAdapter?.submitData(pagingData)
            }
        }
    }

    private fun setUpRecyclerView(){
        pagingAdapter = HeadLineNewsListAdapter(this)
        pagingAdapter?.withLoadStateHeaderAndFooter(
            header = NewsLoadStateAdapter {

            },
            footer = NewsLoadStateAdapter {

            }
        )
        binding.recyclerView.apply {
            adapter = pagingAdapter
            layoutManager = LinearLayoutManager(this@PagingNetworkActivity)
        }
    }

    companion object{

        private const val TAG = "PagingNetworkActivity"
    }
}