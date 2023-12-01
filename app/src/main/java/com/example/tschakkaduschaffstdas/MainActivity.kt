package com.example.tschakkaduschaffstdas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tschakkaduschaffstdas.data.Datasource
import com.example.tschakkaduschaffstdas.data.model.Info
import com.example.tschakkaduschaffstdas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var dataset: List<Info> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataset = Datasource().entry()
    }

    fun addInfo(newInfo: Info) {
        dataset = listOf(newInfo) + dataset
    }
}