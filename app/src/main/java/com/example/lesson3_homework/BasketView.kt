package com.example.lesson3_homework

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface BasketView : MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun print(prices:String)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForSecondName(visible: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForFirstName(visible: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForMiddleName(visible: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForPhone(visible: Boolean)
}