package com.example.lesson3_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BasketView {
    private val presenter = BasketPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.totalPricePrint()

        checkoutPriceValue.text="100"
        checkoutDiscountValue.text="10"
        checkoutSumValue.text="90"
    }

    override fun print(prices: String) {
//        Toast.makeText(this, "$prices", Toast.LENGTH_LONG).show()
        Log.d("Print", "$prices")
    }
}
