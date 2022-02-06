package com.john.episode.presentation.modify

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.john.episode.databinding.FragmentMemoModifyBinding


class MemoModifyFragment : Fragment() {

    private var _binding: FragmentMemoModifyBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<MemoModifyFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =FragmentMemoModifyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() = with(binding) {
        btnModifySave.setOnClickListener {
            //사용자가 입력한 내용 가지고 온다.
            val memoSubject = binding.memoModifySubject.text.toString().trim()
            val memoText = binding.memoModifyText.text.toString().trim()

            // 프래그먼트로 값전달.
            val bundle = bundleOf("memo_subject" to memoSubject, "memo_content" to memoText)
            setFragmentResult(requestKey = "READ", result = bundle)

            // 이전 프래그먼트로 이동.
            findNavController().navigateUp()
        }
    }
}