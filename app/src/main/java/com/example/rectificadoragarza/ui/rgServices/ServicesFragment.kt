package com.example.rectificadoragarza.ui.rgServices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.rectificadoragarza.R
import com.example.rectificadoragarza.databinding.FragmentServicesBinding

class ServicesFragment : Fragment() {
    private var _binding:FragmentServicesBinding? = null;
    private val binding get() = _binding!!;

    //Conexion de viewModel
    private val servicesViewModel by viewModels<ServicesViewModel>(); //delegamos la conexion con el viewModel a  by viewModels
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentServicesBinding.inflate(layoutInflater, container, false);
        return binding.root;
    }

}