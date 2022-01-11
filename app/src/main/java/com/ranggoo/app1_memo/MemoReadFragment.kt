package com.ranggoo.app1_memo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ranggoo.app1_memo.databinding.FragmentMemoReadBinding

class MemoReadFragment : Fragment() {

    private var _binding : FragmentMemoReadBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        _binding = FragmentMemoReadBinding.inflate(inflater, container, false)

        binding.btnDelete.setOnClickListener {
            findNavController().navigate(R.id.action_memoReadFragment_to_mainFragment)

            Toast.makeText(context,"기록이 삭제되었습니다", Toast.LENGTH_SHORT).show()
        }

        binding.btnModify.setOnClickListener {
            findNavController().navigate(R.id.action_memoReadFragment_to_memoModifyFragment)

        }

        binding.btnReadBack.setOnClickListener {
            findNavController().navigate(R.id.action_memoReadFragment_to_mainFragment)

        }
        binding.btnShare.setOnClickListener {

            //자료 찾아보고 넣어보기!!
        }



        return binding.root
    }

   }