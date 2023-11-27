package com.example.rectificadoragarza.ui.rgServices

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rectificadoragarza.domain.IRepository
import com.example.rectificadoragarza.domain.usecase.GetConnecionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ServicesViewModel @Inject constructor(private val getConnecionUseCase: GetConnecionUseCase):ViewModel(){
    private var _state = MutableStateFlow<ServicesState>(ServicesState.Loading); //stado inical
    val state:StateFlow<ServicesState> = _state; //mandamos un estado inicial

    fun getStatusConnection(){
        //Hilo de UI
        viewModelScope.launch {//Nuevo Hilo secundario
            _state.value = ServicesState.Loading;
            withContext(Dispatchers.IO){
                val result = getConnecionUseCase();//getConnecionUseCase();
                if(result!=null){
                    _state.value = ServicesState.Success(result.status.toString());
                }else{
                    _state.value = ServicesState.Error("Error Interno Revice Su Conexión");
                }
            }
        }
    }
}