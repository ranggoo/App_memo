package com.ranggoo.app1_memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ranggoo.app1_memo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var count = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvCount.text = count.toString()
        binding.btnIncrease.setOnClickListener {
            count = count + 1;
            binding.tvCount.text = count.toString()
        }
    }
}