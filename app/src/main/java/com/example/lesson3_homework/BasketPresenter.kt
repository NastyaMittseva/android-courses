package com.example.lesson3_homework

class BasketPresenter(
    val view: BasketView
) {
    private val iphoneCase = Product(price = 155.0, salePercent = 20, productName = "iphoneCase")
    private val samsungCase = Product(price = 123.0, salePercent = 30, productName = "samsungCase")
    private val asusCase = Product(price = 138.0, salePercent = 10, productName = "asusCase")
    private val basket: List<Product> = listOf(iphoneCase, samsungCase, asusCase)

    private fun calcTotalDiscountPrice():Double = basket.map { it.calcDiscountPrice() }.sum()

    fun totalPricePrint(){
        var prices = ""
        basket.forEach() { product ->
            prices +="${product.getProductName()} : ${product.calcDiscountPrice()}\n"
        }
        prices += "Общая цена со скидкой: ${this.calcTotalDiscountPrice()}\n"
        view.print(prices)
    }
}