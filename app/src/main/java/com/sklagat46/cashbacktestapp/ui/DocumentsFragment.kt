package com.sklagat46.cashbacktestapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sklagat46.cashbacktestapp.R
import com.sklagat46.cashbacktestapp.databinding.FragmentAccountBinding
import com.sklagat46.cashbacktestapp.databinding.FragmentDocumentsBinding

class DocumentsFragment : Fragment() {
    private var binding: FragmentDocumentsBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDocumentsBinding.bind(view)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDocumentsBinding.inflate(inflater, container, false)
        return binding?.root
    }
}