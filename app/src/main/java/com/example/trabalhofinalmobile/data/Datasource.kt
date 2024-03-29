package com.example.trabalhofinalmobile.data

import android.util.Log
import com.example.trabalhofinalmobile.adapter.ProductAdapter
import com.example.trabalhofinalmobile.models.Product
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Datasource {
    var products: MutableList<Product> = mutableListOf()
    lateinit var adapter: ProductAdapter
    private var db = Firebase.firestore;

    fun getCatalog() {
        db.collection("catalog")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    var product = document.toObject(Product::class.java)
                    products.add(product)
                    Log.d("Product:","$product")
                }
                adapter.notifyDataSetChanged()
            }
    }
    fun getProduct(name: String) {

    }
}