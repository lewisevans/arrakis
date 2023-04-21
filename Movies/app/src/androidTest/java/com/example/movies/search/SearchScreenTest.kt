package com.example.movies.search

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performTextInput
import com.example.movies.domain.GetAllFilmsByTermUseCase
import com.example.movies.domain.GetAllFilmsUseCase
import com.example.movies.presentation.search.SearchScreen
import com.example.movies.presentation.search.SearchViewModel
import com.example.movies.presentation.search.TEST_TAG_SEARCH_FIELD
import com.example.movies.presentation.search.ViewModelState
import movies.fake.FakeFilmRepository
import org.junit.Rule
import org.junit.Test

class SearchScreenTest {

    @get:Rule
    val rule = createComposeRule()

    private val repo = FakeFilmRepository()

    private val viewModel =
        SearchViewModel(GetAllFilmsUseCase(repo), GetAllFilmsByTermUseCase(repo))

    @Test
    fun test_GIVEN_we_are_any_user_WHEN_we_open_the_application_THEN_we_see_the_search_screen() {
        rule.setContent {
            val state by viewModel.viewModelState.collectAsState(initial = ViewModelState())
            SearchScreen(
                modifier = Modifier,
                viewModelState = state,
                onSearchTextChanged = { viewModel.onSearchTextChanged(it) },
                onClearClick = { viewModel.onClearClick() }
            )
        }
        rule.onNode(hasTestTag(TEST_TAG_SEARCH_FIELD)).performTextInput("F")
        rule.onNode(hasTestTag(TEST_TAG_SEARCH_FIELD)).performTextInput("F")
        rule.onNode(hasTestTag(TEST_TAG_SEARCH_FIELD)).performTextInput("i")
        rule.onNode(hasTestTag(TEST_TAG_SEARCH_FIELD)).performTextInput("l")
        rule.onNode(hasTestTag(TEST_TAG_SEARCH_FIELD)).performTextInput("m")
        rule.onNode(hasText("Film 1")).assertExists()
        // NOT REALLY TESTING ANYTHING HERE
    }

}