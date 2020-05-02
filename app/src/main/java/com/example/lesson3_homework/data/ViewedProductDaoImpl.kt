package com.example.lesson3_homework.data

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.lesson3_homework.domain.ViewedProductDao
import com.example.lesson3_homework.domain.model.Product
import com.example.lesson3_homework.presenter.BasketPresenter

class ViewedProductDaoImpl(
    private val sharedPreferences: SharedPreferences
): ViewedProductDao {

    private var savedProductIds:List<Long>
        get() = sharedPreferences.getString(PRODUCT_TAG,null)?.split(",")
        ?.mapNotNull { it.toLongOrNull() } ?: emptyList()

        set(value) = sharedPreferences.edit {
            putString(PRODUCT_TAG, value.joinToString(","))
        }

    override fun addProduct(productID: Long) {
        val productIds: List<Long> = savedProductIds
        val newProductIds = mutableListOf<Long>().apply {
            add(productID)
            addAll(productIds.filter { it != productID })
        }
        savedProductIds = newProductIds
    }

    override fun getAllProducts(): List<Long> {
        return savedProductIds
    }

    override fun getProductById(productId: Long): Product {
        val products = listOf<Product>(
            Product(
                1,
                "Телефон Samsung1",
                12000.0,
                30
            ),
            Product(2,
                "Телефон Huawei1",
                15000.0,
                10
            ),
            Product(3,
                "Телефон Iphone1",
                25000.0,
                15
            ),
            Product(4,
                "Телефон Samsung2",
                12500.0,
                12
            ),
            Product(5,
                "Телефон Huawei2",
                15500.0,
                17
            ),
            Product(6,
                "Телефон Iphone2",
                25500.0,
                13
            ),
            Product(7,
                "Телефон Samsung3",
                13000.0,
                23
            ),
            Product(8,
                "Телефон Huawei3",
                16000.0,
                25
            ),
            Product(9,
                "Телефон Iphone3",
                26000.0,
                19
            ),
            Product(10,
                "Телефон Samsung4",
                11000.0,
                21

            ),
            Product(11,
                "Телефон Huawei4",
                14000.0,
                33

            ),
            Product(12,
                "Телефон Iphone4",
                24000.0,
                31
            )
        )
        return products.find{ it.id == productId } ?: products[0]
    }

    companion object{
        private const val PRODUCT_TAG = "PRODUCT_TAG"
    }
}