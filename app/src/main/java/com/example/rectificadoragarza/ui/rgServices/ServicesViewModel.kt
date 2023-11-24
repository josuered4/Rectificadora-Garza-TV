package com.example.rectificadoragarza.ui.rgServices

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ServicesViewModel @Inject constructor():ViewModel(){
    private var _state = MutableStateFlow<ServicesState>(ServicesState.Loading); //stado inical
    val state:StateFlow<ServicesState> = _state; //mandamos un estado inicial
}