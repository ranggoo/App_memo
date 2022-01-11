package com.ranggoo.app1_memo

import android.app.Activity
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.MainThread
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ranggoo.app1_memo.databinding.FragmentMainBinding
import com.ranggoo.app1_memo.databinding.MainRecyclerRowBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    val subjectList = ArrayList<String>()
    val dateList = ArrayList<String>()
    val idxList = ArrayList<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_memoAddFragment)
        }

        binding.rv.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_memoReadFragment)
        }

        return binding.root

        initView()




    }

    private fun initView() = with(binding){
        rv.run {


        }

    }



    //앱이 화면에서 삭제 시 메모리에서 삭제가 실행되는 코드!!!!!

    override fun onDestroy() {
        super.onDestroy()
        _binding=null

    }
}