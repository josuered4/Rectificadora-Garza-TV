package com.example.rectificadoragarza.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.example.rectificadoragarza.R
import com.example.rectificadoragarza.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);
        initUi();
    }

    private fun initUi() {
        Toast.makeText(this, "Hola Mundo", Toast.LENGTH_LONG).show();
    }
}