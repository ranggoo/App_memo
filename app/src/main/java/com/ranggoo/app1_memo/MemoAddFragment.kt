package com.ranggoo.app1_memo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ranggoo.app1_memo.databinding.FragmentMemoAdd1Binding


class MemoAddFragment : Fragment() {

    private var _binding: FragmentMemoAdd1Binding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentMemoAdd1Binding.inflate(inflater, container, false)

        binding.btnAddBack.setOnClickListener {
            findNavController().navigate(R.id.action_memoAddFragment_to_mainFragment)
        }
        binding.btnSave.setOnClickListener {
            findNavController().navigate(R.id.action_memoAddFragment_to_mainFragment)
            Toast.makeText(context, "저장되었습니다", Toast.LENGTH_SHORT).show()
        }

        return binding.root


    }

}