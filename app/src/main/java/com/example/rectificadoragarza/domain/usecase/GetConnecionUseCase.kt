package com.example.rectificadoragarza.domain.usecase

import com.example.rectificadoragarza.domain.IRepository
import javax.inject.Inject

class GetConnecionUseCase @Inject constructor(private val repository: IRepository) {
    //con "operator invoke" hace que una clase se comporte como una funcion,
    //asi podemo acceder directamente
    suspend operator fun invoke() = repository.getConnection();
}