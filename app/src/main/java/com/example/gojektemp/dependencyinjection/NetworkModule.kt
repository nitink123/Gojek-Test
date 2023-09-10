package com.example.gojektemp.dependencyinjection

import com.example.gojektemp.network.StarWarsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
     @Provides
    fun getRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl("https://swapi.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getStarWarsApi(retrofit: Retrofit) : StarWarsApiService{
        return retrofit.create(StarWarsApiService::class.java)
    }
}