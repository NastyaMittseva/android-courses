package com.example.lesson3_homework.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson3_homework.BasketPresenter
import com.example.lesson3_homework.Product
import com.example.lesson3_homework.R
import com.example.myapplication.ui.BaseActivity
import kotlinx.android.synthetic.main.basket_layout.*

class BasketActivity: BaseActivity(), BasketView {
    private val presenter = BasketPresenter()
    private val adapter = BasketAdapter{ product ->
        presenter.removeItem(product)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basket_layout)
        basketBackBtn.setOnClickListener{
            startActivity(Intent(this, CatalogActivity::class.java))
        }

        basketRv.layoutManager = LinearLayoutManager(this)
        basketRv.adapter = adapter
        presenter.attachView(this)
        presenter.setData()
    }

    override fun setProducts(list: List<Product>) {
        adapter.setData(list)
    }

    override fun removeItem(position: Int) {
        adapter.notifyItemRemoved(position)
    }
}
