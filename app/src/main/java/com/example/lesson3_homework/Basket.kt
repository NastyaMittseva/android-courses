package com.example.lesson3_homework

class Basket (var products: MutableList<Product> = mutableListOf()) {
    val discountSum get() = products.map {product -> product.getProductSale()}.sum()
    val fullSum get() = products.map {product -> product.getProductPrice()}.sum()
}