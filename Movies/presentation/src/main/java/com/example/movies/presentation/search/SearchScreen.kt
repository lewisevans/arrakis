package com.example.movies.presentation.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movies.presentation.LoadingView

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val viewModelState by viewModel.viewModelState.collectAsState(initial = ViewModelState())

    if (viewModelState.results.isEmpty()) {
        LoadingView()
    } else {
        SearchScreen(
            modifier,
            viewModelState,
            onSearchTextChanged = { viewModel.onSearchTextChanged(it) },
            onClearClick = { viewModel.onClearClick() }
        )
    }
}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    viewModelState: ViewModelState,
    onSearchTextChanged: (String) -> Unit = {},
    onClearClick: () -> Unit = {},
) {
    Column(modifier = modifier) {
        SearchTopAppBar(
            searchText = viewModelState.searchText,
            onSearchTextChanged = onSearchTextChanged,
            onClearClick = onClearClick
        )
        LazyColumn(
            modifier = Modifier.testTag(TEST_TAG_RESULTS_LIST),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(viewModelState.results) {
                FilmItemView(item = it)
            }
        }
    }
}

const val TEST_TAG_RESULTS_LIST = "test_tag_results_list"