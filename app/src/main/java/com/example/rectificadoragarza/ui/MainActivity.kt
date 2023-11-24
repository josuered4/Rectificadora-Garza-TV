package com.example.rectificadoragarza.ui

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.rectificadoragarza.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);
        initUi();
    }

    private fun initUi() {
        Toast.makeText(this, "Bienvenido!!", Toast.LENGTH_LONG).show();
    }
}