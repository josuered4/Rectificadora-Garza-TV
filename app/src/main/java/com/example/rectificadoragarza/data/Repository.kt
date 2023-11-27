package com.example.rectificadoragarza.data

import android.util.Log
import com.example.rectificadoragarza.data.network.RGServicesApiServices
import com.example.rectificadoragarza.domain.IRepository
import com.example.rectificadoragarza.domain.model.StatusConecctionModel
import javax.inject.Inject

class Repository @Inject constructor(private val apiServices: RGServicesApiServices) : IRepository{
    override suspend fun getConnection(): StatusConecctionModel? {
        kotlin.runCatching {
            apiServices.checkConnection()
        }.onSuccess{
            return it.toDomain();
        }.onFailure  {
            Log.i("Error Repositorio", "Ha ocurrido un error ${it.message}")
        }
        return null;
    }

}