package com.example.tschakkaduschaffstdas.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tschakkaduschaffstdas.MainActivity
import com.example.tschakkaduschaffstdas.R
import com.example.tschakkaduschaffstdas.databinding.FragmentMainBinding
import com.example.tschakkaduschaffstdas.ui.adapter.ItemAdapter

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private lateinit var adapter: ItemAdapter
    private lateinit var mainActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }
}