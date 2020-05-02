package com.example.lesson3_homework.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson3_homework.presenter.CatalogPresenter
import com.example.lesson3_homework.R
import com.example.lesson3_homework.data.ViewedProductDaoImpl
import com.example.lesson3_homework.domain.model.Product
import com.example.lesson3_homework.presenter.CatalogView
import com.example.myapplication.ui.BaseActivity
import kotlinx.android.synthetic.main.catalog_layout.*
import moxy.ktx.moxyPresenter

class CatalogActivity: BaseActivity(),
    CatalogView {
    private val presenter by moxyPresenter {
        CatalogPresenter(ViewedProductDaoImpl(sharedPreferences))
    }
    private val categoryAdapter = CategoryAdapter{
            category -> presenter.removeItem(category)
    }
    private val reviewedProductsAdapter = ReviewedProductsAdapter {
            product -> presenter.showProductInfo(product)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)
        Log.d(tag, savedInstanceState.toString())
        val savedInt = savedInstanceState?.getInt(SAVE_SATE_INT)

        catalogCheckoutBtn.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java).apply {
                putExtra(PRODUCT_ID, 1000)
            }
            startActivityForResult(intent, REQUEST_AUTH)
        }

        catalogBasketBtn.setOnClickListener{
            startActivity(Intent(this, BasketActivity::class.java))
        }

        categoryRv.layoutManager = LinearLayoutManager(this)
        categoryRv.adapter = categoryAdapter

        productRv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        productRv.adapter = reviewedProductsAdapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SAVE_SATE_INT, 89)
        super.onSaveInstanceState(outState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (REQUEST_AUTH == requestCode) {
            val isUserAuth = data?.extras?.getBoolean(IS_USER_AUTH)
            Log.d(tag, "onActivityResult ${isUserAuth.toString()}")
        }
    }

    override fun setCategories(list: List<String>) {
        categoryAdapter.setData(list)
    }

    override fun setViewedProducts(products: List<Product>) {
        reviewedProductsAdapter.setData(products)
    }

    override fun removeItem(position: Int) {
        categoryAdapter.notifyItemRemoved(position)
    }

    override fun showProductsIds(productIds: List<Long>) {
//        Toast.makeText(this, productIds.joinToString(","), Toast.LENGTH_LONG).show()
    }

    override fun showProductInfo(product: Product) {
        startActivity(Intent(this, ProductActivity::class.java).apply {
            putExtra(ProductActivity.PRODUCT_TAG, product)
        })
    }

    companion object{
        const val PRODUCT_ID = "PRODUCT_ID"
        const val REQUEST_AUTH:Int = 10
        const val IS_USER_AUTH = "IS_USER_AUTH"
        const val SAVE_SATE_INT = "SAVE_SATE_INT"
    }
}

val AppCompatActivity.sharedPreferences : SharedPreferences
    get() = getSharedPreferences("data", Context.MODE_PRIVATE)

