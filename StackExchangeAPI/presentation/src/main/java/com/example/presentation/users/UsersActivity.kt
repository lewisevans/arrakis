package com.example.presentation.users

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.domain.DomainResponse
import com.example.presentation.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersActivity : AppCompatActivity() {

    private val viewModel: UsersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getUsers("droppin_scienc").observe(this) { response ->
            when(response){
                is DomainResponse.Content -> {
                    Log.d("DomainResponse", "Content = ${response.result}")
                }
                is DomainResponse.Error -> Log.d("DomainResponse", "Error")
                DomainResponse.Loading -> Log.d("DomainResponse", "Loading")
            }
        }
    }
}