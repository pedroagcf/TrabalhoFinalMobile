package com.example.trabalhofinalmobile.home.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalhofinalmobile.R
import com.example.trabalhofinalmobile.adapter.ProductAdapter
import com.example.trabalhofinalmobile.data.Datasource
import com.example.trabalhofinalmobile.home.viewmodel.HomeViewModel

class HomeActivity: AppCompatActivity() {

    var productDataSource = Datasource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView = findViewById<RecyclerView>(R.id.product_list_rv)
        val adapter = ProductAdapter(this, productDataSource)

        recyclerView.adapter = adapter
    }

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(
            HomeViewModel::class.java
        )
    }
}