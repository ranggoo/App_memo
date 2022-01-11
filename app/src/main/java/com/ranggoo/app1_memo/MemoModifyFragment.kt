package com.ranggoo.app1_memo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ranggoo.app1_memo.databinding.FragmentMemoModifyBinding


class MemoModifyFragment : Fragment() {

    private var _binding: FragmentMemoModifyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



        _binding =FragmentMemoModifyBinding.inflate(inflater, container, false)

        binding.btnModifyBack.setOnClickListener{
            findNavController().navigate(R.id.action_memoModifyFragment_to_memoReadFragment)
        }
        binding.btnModifySave.setOnClickListener {
            findNavController().navigate(R.id.action_memoModifyFragment_to_memoReadFragment)
            Toast.makeText(context,"기록이 수정되었습니다", Toast.LENGTH_SHORT).show()
        }


        return binding.root
    }

}