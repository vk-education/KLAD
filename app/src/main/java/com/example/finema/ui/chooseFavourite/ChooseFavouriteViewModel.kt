package com.example.finema.ui.chooseFavourite

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.finema.api.MoviesRepository
import com.example.finema.models.infinite.MovieDiscoverResult
import com.example.finema.ui.base.BaseViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ChooseFavouriteViewModel(
    private val repository: MoviesRepository
) : BaseViewModel() {

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    val movies: Flow<PagingData<MovieDiscoverResult>> = query
        .map(::newPager)
        // TODO Попробовать с map
        .flatMapLatest { pager -> pager.flow.cachedIn(viewModelScope) }
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty()) // TODO ??????

    private fun newPager(query: String): Pager<Int, MovieDiscoverResult> {
        return Pager(
            PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            )
        ) {
            MoviePagingSource(repository.api, query)
        }
    }

    fun setQuery(query: String) {
        _query.tryEmit(query)
    }
}
