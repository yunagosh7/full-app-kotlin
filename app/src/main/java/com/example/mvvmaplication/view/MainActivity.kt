package com.example.mvvmaplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.mvvmaplication.databinding.ActivityMainBinding
import com.example.mvvmaplication.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = MainActivityViewModel()

        initUI()
        
        binding.viewContainer.setOnClickListener {
            viewModel.randomQuote()
        }
        
        viewModel.quoteModel.observe(this, Observer {
            binding.tvAuthor.text = it.author
            binding.tvQuote.text = it.quote
        })
    }

    private fun initUI() {
        viewModel.randomQuote();
    }
}