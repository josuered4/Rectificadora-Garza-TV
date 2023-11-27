package com.example.rectificadoragarza.domain

import com.example.rectificadoragarza.data.network.response.StatusConnectionResponse
import com.example.rectificadoragarza.domain.model.StatusConecctionModel

interface IRepository {

    suspend fun getConnection(): StatusConecctionModel?;
}