package com.example.movies.presentation.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movies.domain.FilmDomainEntity
import com.example.movies.domain.GetAllFilmsByTermUseCase
import com.example.movies.domain.GetAllFilmsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getAllFilms: GetAllFilmsUseCase,
    private val getAllFilmsByTermUseCase: GetAllFilmsByTermUseCase
) : ViewModel() {

    private val searchText: MutableStateFlow<String> = MutableStateFlow("")
    private val searchResult: MutableStateFlow<List<FilmDomainEntity>> =
        MutableStateFlow(emptyList())

    init {
        searchText
            .debounce(500)
            .onEach { searchText ->
                if (searchText.length > 2) {
                    getAllFilmsByTermUseCase
                        .invoke(searchText)
                        .collectLatest { res ->
                            Log.d("RESULTS_RESULTS", res.toString())
                            searchResult.value = res
                        }
                } else {
                    getAllFilms
                        .invoke()
                        .collectLatest { res ->
                            Log.d("RESULTS_RESULTS", res.toString())
                            searchResult.value = res
                        }

                }
            }
            .launchIn(viewModelScope)
    }

    val viewModelState = combine(
        searchText,
        searchResult,
    ) { searchText, results ->
        ViewModelState(
            searchText = searchText,
            results = results,
        )
    }

    fun onSearchTextChanged(changedSearchText: String) {
        searchText.value = changedSearchText
        Log.d("RESULTS_RESULTS", changedSearchText)
    }

    fun onClearClick() {
        searchText.value = ""
    }

}