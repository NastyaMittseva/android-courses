package com.example.lesson3_homework.presenter

import android.util.Log
import com.example.lesson3_homework.domain.ViewedProductDao
import com.example.lesson3_homework.domain.model.Product
import moxy.MvpPresenter

class ProductPresenter(private val viewedProductDao: ViewedProductDao):
    MvpPresenter<ProductView>()  {
    fun onProductShow(product: Product) {
        viewedProductDao.addProduct(product.id)
    }
}