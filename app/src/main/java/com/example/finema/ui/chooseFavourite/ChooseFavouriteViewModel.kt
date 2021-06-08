package com.example.finema.ui.chooseFavourite

import android.os.Bundle
import androidx.lifecycle.viewModelScope
import androidx.navigation.Navigation
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.finema.R
import com.example.finema.api.MoviesRepository
import com.example.finema.models.infinite.MovieDiscoverResult
import com.example.finema.ui.base.BaseViewModel
import com.example.finema.util.APP_ACTIVITY
import kotlinx.coroutines.flow.*

class ChooseFavouriteViewModel(
    private val repository: MoviesRepository
) : BaseViewModel() {

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    val movies: Flow<PagingData<MovieDiscoverResult>> = query
        .map(::newPager)
            //TODO Попробовать с map
        .flatMapLatest { pager -> pager.flow.cachedIn(viewModelScope) }
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty()) //TODO ??????

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
