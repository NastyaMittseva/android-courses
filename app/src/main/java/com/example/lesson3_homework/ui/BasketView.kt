package com.example.lesson3_homework.ui

import com.example.lesson3_homework.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BasketView : MvpView{

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setProducts(list: List<Product>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun removeItem(position: Int)
}