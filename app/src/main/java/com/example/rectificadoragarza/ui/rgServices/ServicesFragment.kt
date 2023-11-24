package com.example.rectificadoragarza.ui.rgServices

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.rectificadoragarza.databinding.FragmentServicesBinding
import kotlinx.coroutines.launch

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI();
    }

    private fun initUI() {
        initUIState();
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                servicesViewModel.state.collect{
                    when(it){
                        ServicesState.Loading -> loadingState();
                        is ServicesState.Error -> errorState();
                        is ServicesState.Success -> successState();
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.layoutLoading.isVisible = true;
    }
    private fun errorState() {
    }
    private fun successState() {
    }




}