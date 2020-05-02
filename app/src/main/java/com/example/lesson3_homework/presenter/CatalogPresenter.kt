package com.example.lesson3_homework.presenter

import android.util.Log
import com.example.lesson3_homework.domain.ViewedProductDao
import com.example.lesson3_homework.domain.model.Product
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class CatalogPresenter(
    private val viewedProductDao:ViewedProductDao
): MvpPresenter<CatalogView>() {
    private val list = mutableListOf("Телевизоры", "Телефоны", "Планшеты", "Часы", "Компьютеры", "Ноутбуки")

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        setData()
    }

    override fun attachView(view: CatalogView?) {
        super.attachView(view)
        val productIds = viewedProductDao.getAllProducts()
        Log.d("productIds", "$productIds")
//        viewState.showProductsIds(productIds)
        val products = productIds.map{ viewedProductDao.getProductById(it) }
        viewState.setViewedProducts(products)
    }

    fun setData(){
        viewState.setCategories(list)
    }

    fun removeItem(category: String){
        val position = list.indexOf(category)
        list.remove(category)
        viewState.removeItem(position)
    }

    fun showProductInfo(product: Product) {
        viewState.showProductInfo(product)
    }
}