package com.example.lesson3_homework.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson3_homework.CatalogPresenter
import com.example.lesson3_homework.R
import com.example.myapplication.ui.BaseActivity
import kotlinx.android.synthetic.main.catalog_layout.*

class CatalogActivity: BaseActivity(), CatalogView {
    private val presenter = CatalogPresenter()
    private val adapter = CategoryAdapter{category ->
        presenter.removeItem(category)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)
        Log.d(tag, savedInstanceState.toString())
        val savedInt = savedInstanceState?.getInt(SAVE_SATE_INT)
        Log.d(tag, "savedInt $savedInt")

        catalogCheckoutBtn.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java).apply {
                putExtra(PRODUCT_ID, 1000)
            }
            startActivityForResult(intent, REQUEST_AUTH)
        }

        catalogBasketBtn.setOnClickListener{
            startActivity(Intent(this, BasketActivity::class.java))
        }

        catalogProductBtn.setOnClickListener{
            startActivity(Intent(this, ProductActivity::class.java))
        }

        categoryRv.layoutManager = LinearLayoutManager(this)
        categoryRv.adapter = adapter
        presenter.attachView(this)
        presenter.setData()
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
        adapter.setData(list)
    }

    override fun removeItem(position: Int) {
        adapter.notifyItemRemoved(position)
    }

    companion object{
        const val PRODUCT_ID = "PRODUCT_ID"
        const val REQUEST_AUTH:Int = 10
        const val IS_USER_AUTH = "IS_USER_AUTH"
        const val SAVE_SATE_INT = "SAVE_SATE_INT"
    }
}