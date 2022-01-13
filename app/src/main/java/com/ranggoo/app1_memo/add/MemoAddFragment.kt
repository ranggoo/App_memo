package com.ranggoo.app1_memo.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.ranggoo.app1_memo.db.DBHelper
import com.ranggoo.app1_memo.databinding.FragmentMemoAdd1Binding


class MemoAddFragment : Fragment() {

    private var _binding: FragmentMemoAdd1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMemoAdd1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() = with(binding){
        btnSave.setOnClickListener {
            //사용자가 입력한 내용 가지고 온다.
            val memoSubject = binding.addMemoSubject.text.toString().trim()
            val memoText = binding.addMemoText.text.toString().trim()

            // 글내용 디비 저장.
            DBHelper()
                .insertMemo(
                    memoSubject = memoSubject,
                    memoText = memoText
                )

            // 프래그먼트로 값전달.
            val bundle = bundleOf("memo_subject" to memoSubject, "memo_content" to memoText)
            setFragmentResult(requestKey = "ADD", result = bundle)

            // 이전 프래그먼트로 이동.
            findNavController().navigateUp()
        }
    }


}