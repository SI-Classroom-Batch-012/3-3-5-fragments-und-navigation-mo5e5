package com.example.tschakkaduschaffstdas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tschakkaduschaffstdas.data.Datasource
import com.example.tschakkaduschaffstdas.data.adapter.ItemAdapter
import com.example.tschakkaduschaffstdas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val info = Datasource().entry()

        val recyclerView = binding.mainRV

        val adapter = ItemAdapter(info)

        recyclerView.adapter = adapter
    }
}