package com.example.finema.ui.chooseFavourite

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.finema.api.MoviesApi
import com.example.finema.models.infinite.MovieDiscoverResult
import java.lang.NullPointerException
import retrofit2.HttpException

class MoviePagingSource(
    private val api: MoviesApi,
    private val query: String
) : PagingSource<Int, MovieDiscoverResult>() {

    override suspend fun load(params: LoadParams<Int>):
        LoadResult<Int, MovieDiscoverResult> {
            return try {
                val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
                val response = api.everything(pageNumber, query)

                if (response.isSuccessful) {
                    val movies = response.body()!!.results
                    val nextPageNumber = if (movies.isEmpty()) null else pageNumber + 1
                    val prevPageNumber = if (pageNumber > 1) pageNumber - 1 else null
                    LoadResult.Page(movies, prevPageNumber, nextPageNumber)
                } else {
                    LoadResult.Error(HttpException(response))
                }
            } catch (e: HttpException) {
                LoadResult.Error(e)
            } catch (e: NullPointerException) {
                LoadResult.Error(e)
            }
        }

    override fun getRefreshKey(state: PagingState<Int, MovieDiscoverResult>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    companion object {
        const val INITIAL_PAGE_NUMBER = 1
    }
}
