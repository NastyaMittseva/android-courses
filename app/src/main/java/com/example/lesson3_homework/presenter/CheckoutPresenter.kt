package com.example.lesson3_homework.presenter

import com.example.lesson3_homework.domain.model.CreateOrderModel
import com.example.lesson3_homework.domain.model.Product
import moxy.MvpPresenter

class CheckoutPresenter : MvpPresenter<CheckoutView>() {
//    private val iphoneCase = Product(
//        price = 155.0,
//        salePercent = 20,
//        productName = "iphoneCase"
//    )
//    private val samsungCase = Product(
//        price = 123.0,
//        salePercent = 30,
//        productName = "samsungCase"
//    )
//    private val asusCase = Product(
//        price = 138.0,
//        salePercent = 10,
//        productName = "asusCase"
//    )
//    private val basket: List<Product> = listOf(iphoneCase, samsungCase, asusCase)

    private val model = CreateOrderModel()

    fun checkFirstName(text:String){
        if (!checkSymbols(text)) model.firstName = text
        viewState.showErrorForFirstName(checkSymbols(text))
    }

    fun checkSecondName(text:String){
        if (!checkSymbols(text)) model.secondName = text
        viewState.showErrorForSecondName(checkSymbols(text))
    }

    fun checkMiddleName(text:String){
        if (!checkSymbols(text)) model.middleName = text
        viewState.showErrorForMiddleName(checkSymbols(text))
    }

    fun checkPhone(text:String){
        if (!checkStringPhone(text)) model.phone = text
        viewState.showErrorForPhone(checkStringPhone(text))
    }

    private fun checkSymbols(text:String): Boolean = text.length < 3

    private fun checkStringPhone(text: String):Boolean = !(Regex("(\\+7|8)\\d{10}").matches(text))

//    private fun calcTotalDiscountPrice():Double = basket.map { it.calcDiscountPrice() }.sum()

//    fun totalPricePrint(){
//        var prices = ""
//        basket.forEach() { product ->
//            prices +="${product.getProductName()} : ${product.calcDiscountPrice()}\n"
//        }
//        prices += "Общая цена со скидкой: ${this.calcTotalDiscountPrice()}\n"
//        viewState.print(prices)
//    }
}