package com.example.tschakkaduschaffstdas.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tschakkaduschaffstdas.MainActivity
import com.example.tschakkaduschaffstdas.databinding.FragmentHomeBinding
import com.example.tschakkaduschaffstdas.ui.adapter.ItemAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var adapter: ItemAdapter
    private lateinit var mainActivity: MainActivity


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity = activity as MainActivity

        val dataset = mainActivity.dataset

        adapter = ItemAdapter(dataset)
        binding.mainRV.adapter = adapter
    }
}