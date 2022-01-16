package com.ranggoo.app1_memo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.ranggoo.app1_memo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // #1 인터페이스를 만듬.
    // - 인터페이스는 구현을 강제하기위한 목적이므로 구현체가 필요함!
    interface TestInterface {
        fun test1(stringData: String)
        fun test2(IntegerData: Int)
        fun test3(doubleData: Double)
    }

    // #2 인터페이스 객체 선언.
    lateinit var testInterface: TestInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val viewModel by viewModels<MainViewModel>()
        setContentView(binding.root)


        // #3 이렇게 익명클래스 객체를 만들어줌.
        testInterface = object : TestInterface {
            override fun test1(stringData: String) {
                Log.d("TestInterface", "stringData: $stringData")
            }

            override fun test2(IntegerData: Int) {
                Log.d("TestInterface", "IntegerData: $IntegerData")
            }

            override fun test3(doubleData: Double) {
                Log.d("TestInterface", "doubleData: $doubleData")
            }
        }

        // #4 이렇게 하면 인터페이스 안 구현한 함수을 호출 가능!
        testInterface.test1("테스트 스트링 데이터.")
        testInterface.test2(333)
        testInterface.test3(33.21)

        binding.tvCount.text = viewModel.getCurrentCount().toString()
        binding.btnIncrease.setOnClickListener {
            viewModel.getUpdatedCount()
            binding.tvCount.text = viewModel.getCurrentCount().toString()
        }
    }
}

