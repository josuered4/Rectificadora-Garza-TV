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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
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
        servicesViewModel.getStatusConnection();
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
                        is ServicesState.Error -> errorState(it);
                        is ServicesState.Success -> successState(it);
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.layoutLoading.isVisible = true;
    }
    private fun errorState(servicesState: ServicesState.Error) {
        binding.layoutLoading.isVisible = false;
        binding.textView.text = servicesState.error;
    }
    private fun successState(servicesState: ServicesState.Success) {
        binding.layoutLoading.isVisible = false;
        binding.textView.text = servicesState.data;
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}