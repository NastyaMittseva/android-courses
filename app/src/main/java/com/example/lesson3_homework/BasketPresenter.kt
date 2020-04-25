package com.example.lesson3_homework

import com.example.lesson3_homework.ui.BasketView
import moxy.MvpPresenter

class BasketPresenter: MvpPresenter<BasketView>() {
    private val basket = Basket(mutableListOf(
        Product(12000.0, 30, "Телефон Samsung1"),
        Product(15000.0, 10, "Телефон Huawei1"),
        Product(25000.0, 15, "Телефон Iphone1"),
        Product(12500.0, 12, "Телефон Samsung2"),
        Product(15500.0, 17, "Телефон Huawei2"),
        Product(25500.0, 13, "Телефон Iphone2"),
        Product(13000.0, 23, "Телефон Samsung3"),
        Product(16000.0, 25, "Телефон Huawei3"),
        Product(26000.0, 19, "Телефон Iphone3"),
        Product(11000.0, 21, "Телефон Samsung4"),
        Product(14000.0, 33, "Телефон Huawei4"),
        Product(24000.0, 31, "Телефон Iphone4")
    ))

    fun setData(){
        viewState.setProducts(basket.products)
    }

    fun removeItem(productName: String){
        val position = basket.products.indexOf(
            basket.products.find { product -> product.getProductName() == productName }
        )
        basket.products.removeAt(position)
        viewState.removeItem(position)
    }
}