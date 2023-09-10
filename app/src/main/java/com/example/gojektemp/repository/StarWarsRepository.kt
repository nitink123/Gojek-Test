package com.example.gojektemp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.gojektemp.network.StarWarsApiService
import com.example.gojektemp.pagination.StarWarsPaging
import javax.inject.Inject

class StarWarsRepository @Inject constructor(val starWarsApiService: StarWarsApiService) {

    // the work of repository is to provide the data and we get the data from the paging source
    fun getStarWarsData() = Pager(
     config = PagingConfig(10,50),
        pagingSourceFactory = {StarWarsPaging(starWarsApiService)}

    ).liveData
}