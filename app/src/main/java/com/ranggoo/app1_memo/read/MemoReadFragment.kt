package com.ranggoo.app1_memo.read

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        return binding.root
    }
}