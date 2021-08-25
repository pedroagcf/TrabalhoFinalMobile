package com.example.trabalhofinalmobile.data

import com.example.trabalhofinalmobile.models.Product
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Datasource {
    var products: MutableList<Product> = mutableListOf(
        Product("produto 1"),
        Product("produto 2"),
        Product("produto 3"),
        Product("produto 4"),
        Product("produto 5"),
    )

    fun getRealTimeDatabase() {
//        val database = Firebase.database
        val database = FirebaseDatabase.getInstance()
        val reference =
            database.getReference("/catalog")

        myRef.setValue("primeiro prato do menu")
    }
}