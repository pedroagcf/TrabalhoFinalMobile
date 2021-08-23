package com.example.trabalhofinalmobile.data

import com.example.trabalhofinalmobile.models.Product

class Datasource {
    var products: MutableList<Product> = mutableListOf(
        Product("produto 1"),
        Product("produto 2"),
        Product("produto 3"),
        Product("produto 4"),
        Product("produto 5"),
    )
}