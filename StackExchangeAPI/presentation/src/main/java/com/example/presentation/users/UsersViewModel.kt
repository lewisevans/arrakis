package com.example.presentation.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.DomainResponse
import com.example.domain.user.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val useCase: GetUsersUseCase
) : ViewModel() {
    fun getUsers(searchString: String) = liveData {
        emit(DomainResponse.Loading)
        emit(useCase.execute(searchString))
    }
}