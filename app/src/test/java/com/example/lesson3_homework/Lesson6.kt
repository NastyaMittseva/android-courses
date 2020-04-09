import org.junit.Test

class Lesson6 {

    @Test
    fun example() {
        val presenter = Presenter()
        presenter.pricePrint()
        presenter.productNamePrint()
        presenter.productNamePricePrint()
    }
}

class Presenter() {
    private val iphoneCase = Product(price = 123.5, salePercent = 30, productName = "IphoneCase")
    private val samsungCase = Product(price = 124.5, salePercent = 15, productName = "SamsungCase")
    private val pricePrinter: PricePrinter = ConsolePricePrinter()
    private val products = listOf(iphoneCase, samsungCase)

    fun pricePrint(){
        products.forEach(){
                product->pricePrinter.print(product.calcDiscountPrice())
        }
    }
    fun productNamePrint(){
        products.forEach(){
                product->pricePrinter.print(product.getProductName())
        }
    }

    fun productNamePricePrint(){
        products.forEach(){
                product->pricePrinter.print("${product.getProductName()} : ${product.calcDiscountPrice()}")
//                product->pricePrinter.print(product.getProductName(), product.calcDiscountPrice())
        }
    }
}

class Product(
    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int = 0,
    private val productName: String
) {
    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 than product will have negative price
     * If [salePercent] less than 0 product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
    fun getProductName(): String = productName
}

interface PricePrinter {

    /**
     * Outputs price in <PRICE>P format.
     * If price have not fractional part than it will be printed as integer
     * If price have fractional part than it will be rounded for 2 symbols after "."
     */
    fun print(price: Double)
    fun print(name:String)
    fun print(name:String, price: Double)
}

class ConsolePricePrinter : PricePrinter {

    override fun print(price: Double) {
        println(price)
    }
    override fun print(name:String){
        println(name)
    }
    override fun print(name:String, price: Double){
        println("$name: $price")
    }
}
