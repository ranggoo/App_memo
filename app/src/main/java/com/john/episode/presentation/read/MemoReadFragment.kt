package com.john.episode.presentation.read

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.john.episode.R
import com.john.episode.databinding.FragmentMemoReadBinding

class MemoReadFragment : Fragment() {

    private var _binding: FragmentMemoReadBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<MemoReadFragmentArgs>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMemoReadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("readFragment", "${args.memo}")
        initView()

    }

    private fun initView() = with(binding) {
        val memoEntity=args.memo
        memoReadSubject.text = memoEntity.title
        memoReadText.text = memoEntity.content

        binding.btnModify.setOnClickListener{
            Toast.makeText(context,"메모를 수정합니다", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_memoReadFragment_to_memoModifyFragment)
        }

        binding.btnDelete.setOnClickListener{
            Toast.makeText(context,"메모를 삭제합니다", Toast.LENGTH_SHORT).show()

        }
    }
}