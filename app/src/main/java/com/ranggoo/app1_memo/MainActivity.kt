package com.ranggoo.app1_memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ranggoo.app1_memo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val viewModel by viewModels<MainViewModel>()
        setContentView(binding.root)
        binding.tvCount.text = viewModel.getCurrentCount().toString()
        binding.btnIncrease.setOnClickListener {
            viewModel.getUpdatedCount()
            binding.tvCount.text = viewModel.getCurrentCount().toString()
        }
    }
}