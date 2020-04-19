package com.example.lesson3_homework.ui

import android.os.Bundle
import com.example.lesson3_homework.R
import com.example.myapplication.ui.BaseActivity
import kotlinx.android.synthetic.main.basket_layout.*

class BasketActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basket_layout)
        basketBackBtn.setOnClickListener{
            finish()
        }
    }
}
