package com.example.lesson3_homework.domain

import com.example.lesson3_homework.domain.model.Product

interface ViewedProductDao {
    /*
    * save this product id as viewed
    */
    fun addProduct(productID: Long)

    /*
    * get all viewed products ids
    * might be empty
    */
    fun getAllProducts():List<Long>

    fun getProductById(productId: Long): Product
}