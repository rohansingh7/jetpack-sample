package com.byjus.jetpack.paging

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.byjus.jetpack.paging.databinding.ActivityPageListBinding
import com.byjus.jetpack.paging.databinding.ActivityPagingBinding
import com.byjus.jetpack.paging.feature.networkonly.PagingNetworkActivity

class PagingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPagingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOnlyNetwork.setOnClickListener {
            gotToActivity(PagingNetworkActivity::class.java)
        }

        binding.btnWithDatabase.setOnClickListener {
        //    gotToActivity(PagingNetworkActivity::class.java)
        }


    }

    private fun gotToActivity(target: Class<out Activity>){
        startActivity(Intent(this, target))
    }


}