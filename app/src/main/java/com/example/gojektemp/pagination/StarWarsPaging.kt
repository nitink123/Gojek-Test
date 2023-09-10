package com.example.gojektemp.pagination

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.gojektemp.models.Results
import com.example.gojektemp.network.StarWarsApiService

class StarWarsPaging(var starWarsApiService: StarWarsApiService) : PagingSource<Int, Results>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {
   return   try {
          val position = params.key?:1
          val response = starWarsApiService.getData(position)
           LoadResult.Page(
              data = response.results,
              prevKey =  if (position == 0)null else position-1,
              nextKey =  if (position < response.count!!)position+1 else null,


          )
      }catch (e : Exception){
          LoadResult.Error(e)
      }
    }



    override fun getRefreshKey(state: PagingState<Int, Results>): Int? {
        return state.anchorPosition?.let {it
            state.closestPageToPosition(it)?.prevKey?.plus(1)?:state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}