package com.example.listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapter.adapter.PersonListAdapter
import com.example.listadapter.databinding.ActivityMainBinding
import com.example.listadapter.util.Provider

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //ここで呼び出すことと，外で呼び出すことの違いは??
        val listAdapter = PersonListAdapter()

        binding.recyclerview.adapter = listAdapter
        binding.recyclerview.layoutManager = LinearLayoutManager(applicationContext)
        listAdapter.submitList(Provider.personList)
    }
}