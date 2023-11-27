package com.example.rectificadoragarza.data.network

import com.example.rectificadoragarza.data.Repository
import com.example.rectificadoragarza.domain.IRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton //Hace referencia al patron de diseño
    fun provideRetrofit():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("http://192.168.1.68/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    @Provides //Inyeccion entre provedores
    fun provideRGServicesApiServices(retrofit: Retrofit): RGServicesApiServices{
        return retrofit.create(RGServicesApiServices::class.java);
    }

    @Provides
    fun provideRepository(apiServices: RGServicesApiServices):IRepository{
        return Repository(apiServices);
    }
    //Esto es un poco mas parecido a C# definimos que queremos retornar un IRepositorio
    //y retornamos el servicio que lo implemente
}

//Para poder inyectar librerias e interfaces, dagger pone a
//disposicion artefactos de nombre "Modulos", los cuales se definen
// con la etiqueta "@Module" y definir el alcance con @InstallIn

//Nota
//En pocas palabras los modulos son clases especiales que exponen metodos "provedores"
//que retornan objetos, los metodos inyectan los servicios por asi decir.


