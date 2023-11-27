package com.example.rectificadoragarza.data.network

import com.example.rectificadoragarza.data.network.response.ScreenResponse
import com.example.rectificadoragarza.data.network.response.StatusConnectionResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RGServicesApiServices {

    //Definimos las rutas que retrofit accedera;

    @GET("api/talleres")
    suspend fun checkConnection() : StatusConnectionResponse;//se usa suspen dado a que es una corrutina

    @GET("api/talleres/listaPantallas")
    suspend fun screenslist() : List<ScreenResponse>;

    //@GET("api/talleres/{id}")
    //suspend fun getScreen(@Path("id") result: String)
}