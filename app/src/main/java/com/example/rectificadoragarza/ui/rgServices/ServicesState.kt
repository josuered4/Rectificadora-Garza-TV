package com.example.rectificadoragarza.ui.rgServices

//Estados y valores

sealed class ServicesState {
    data object Loading:ServicesState();
    data class Error(val error:String):ServicesState();
    data class Success(val data:String):ServicesState();
}