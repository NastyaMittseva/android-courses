package com.example.lesson3_homework.presenter

import android.util.Log
import com.example.lesson3_homework.domain.MainApi
import com.example.lesson3_homework.domain.ViewedProductDao
import com.example.lesson3_homework.domain.model.Product
import moxy.InjectViewState
import kotlinx.coroutines.launch
import java.net.ConnectException
import java.net.UnknownHostException


@InjectViewState
class CatalogPresenter(
    private val mainApi: MainApi,
    private val viewedProductDao:ViewedProductDao
): BasePresenter<CatalogView>() {
    private val list = mutableListOf("Телевизоры", "Телефоны", "Планшеты", "Часы", "Компьютеры", "Ноутбуки")

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        launch {
            val remoteProducts = mainApi.allProducts("default")
            val productNames = remoteProducts.map { remoteProduct -> remoteProduct.name }
            viewState.setProductNames(productNames)
        }
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
        viewState.setProductNames(list)
    }

    fun removeItem(category: String){
        val position = list.indexOf(category)
        list.remove(category)
        viewState.removeItem(position)
    }

    fun showProductInfo(product: Product) {
        viewState.showProductInfo(product)
    }

    override fun onFailure(e: Throwable) {
        super.onFailure(e)
        if (e is ConnectException){
            viewState.showError("Ошибка сети, подключитесь к интернету")
        }
        if (e is UnknownHostException){
            viewState.showError("Ошибка соединения с сервером")
        }

    }
}