package com.example.lesson3_homework

import org.junit.Test

class HomeWorkLesson4 {
    @Test
    fun example() {

        val iphoneCase = Product(price = 123.0, salePercent = 10)

        val pricePrinter: PricePrinter = SimplePricePrinter()

        val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()
        pricePrinter.print(discountIphoneCasePrice)
    }
}

class Product (
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0
) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
}

interface PricePrinter {
    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print(price: Double)
}

class SimplePricePrinter : PricePrinter{
    override fun print(price: Double) {
        val newPrice:String 
        newPrice = if (price % 1 == 0.0) {
            price.toInt().toString()
        } else {
            String.format("%.2f", price)
        }
        print("$newPrice P")
    }
}