package com.example.lesson3_homework.ui

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface CatalogView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setCategories(list: List<String>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun removeItem(position: Int)
}