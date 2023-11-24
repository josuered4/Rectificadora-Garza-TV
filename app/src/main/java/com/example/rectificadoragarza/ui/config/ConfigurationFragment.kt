package com.example.rectificadoragarza.ui.config

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rectificadoragarza.databinding.FragmentConfigurationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfigurationFragment : Fragment() {

    private var _binding:FragmentConfigurationBinding? = null;
    private val binding get() = _binding!!; //se sobre escribe el get
    override fun onCreateView( //Este crea la vista
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {
        _binding = FragmentConfigurationBinding.inflate(layoutInflater, container, false);
        return binding.root;
    }


}