package com.ranggoo.app1_memo.modify

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
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
        _binding =FragmentMemoModifyBinding.inflate(inflater, container, false)
        return binding.root
    }
}