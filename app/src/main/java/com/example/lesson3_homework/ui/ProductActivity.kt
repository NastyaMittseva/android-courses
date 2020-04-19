package com.example.lesson3_homework.ui

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.lesson3_homework.R
import com.example.myapplication.ui.BaseActivity
import kotlinx.android.synthetic.main.product_layout.*

class ProductActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_layout)
        productBackBtn.setOnClickListener(){
            finish()
        }
    }

}