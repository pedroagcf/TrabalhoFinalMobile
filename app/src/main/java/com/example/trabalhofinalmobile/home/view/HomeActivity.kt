package com.example.trabalhofinalmobile.home.view

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.trabalhofinalmobile.home.viewmodel.HomeViewModel

class HomeActivity: AppCompatActivity() {

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(
            HomeViewModel::class.java
        )
    }

}