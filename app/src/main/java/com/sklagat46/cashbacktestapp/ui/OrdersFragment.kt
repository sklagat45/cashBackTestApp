package com.sklagat46.cashbacktestapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sklagat46.cashbacktestapp.R
import com.sklagat46.cashbacktestapp.databinding.FragmentHomeBinding
import com.sklagat46.cashbacktestapp.databinding.FragmentOrdersBinding

class OrdersFragment : Fragment() {
    private var binding: FragmentOrdersBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOrdersBinding.bind(view)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrdersBinding.inflate(inflater, container, false)
        return binding?.root
    }
}