package com.example.rectificadoragarza.data.network.response

import com.example.rectificadoragarza.domain.model.StatusConecctionModel
import com.google.gson.annotations.SerializedName

data class StatusConnectionResponse (@SerializedName("status") val status:Int) {

    //Es una funcion de extencion que nos ayudar a mapear datos
    fun toDomain(): StatusConecctionModel {
        return StatusConecctionModel(status = status); //es casi similar al operador cast de c#
    }
};