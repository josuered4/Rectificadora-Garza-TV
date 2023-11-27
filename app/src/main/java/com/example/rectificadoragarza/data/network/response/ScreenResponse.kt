package com.example.rectificadoragarza.data.network.response

import com.google.gson.annotations.SerializedName

/*
{
    "id": 1,
    "nombre": "Pantalla Uno",
    "estado": 1
},*/
data class ScreenResponse (
        @SerializedName("id") val id:Int,
        @SerializedName("nombre") val name:String,
        @SerializedName("estado") val status:Int,
    );