package com.example.rectificadoragarza.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.rectificadoragarza.R
import com.example.rectificadoragarza.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null;
    private val binding get() = _binding!!; //se sobre escribe el get
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI();
    }

    private fun initUI() {
        binding.btnConfig.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToConfigurationFragment());
        }
        binding.btnConfi.setOnClickListener{
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToServicesFragment());

        }
    }
}