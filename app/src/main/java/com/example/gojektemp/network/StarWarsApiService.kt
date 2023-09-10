package com.example.gojektemp.network

import com.example.gojektemp.models.starwarspeopledata
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarWarsApiService  {



   @GET("api/people/")
   suspend fun getData(@Query("page") Page: Int): starwarspeopledata



}