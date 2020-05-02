package com.example.lesson3_homework.presenter

import com.example.lesson3_homework.domain.model.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface CatalogView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setCategories(list: List<String>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setViewedProducts(products: List<Product>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun removeItem(position: Int)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showProductsIds(productIds: List<Long>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProductInfo(product: Product)
}