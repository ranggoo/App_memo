package com.ranggoo.app1_memo.presentation.read

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ranggoo.app1_memo.databinding.FragmentMemoReadBinding

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
    }
}