package com.example.gojektemp.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.gojektemp.repository.StarWarsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class StarWarsVM  @Inject constructor(repository: StarWarsRepository) : ViewModel() {

    val list = repository.getStarWarsData().cachedIn(viewModelScope)
}