package com.example.lesson3_homework.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import com.example.lesson3_homework.BasketPresenter
import com.example.lesson3_homework.BasketView
import com.example.lesson3_homework.R
import com.example.lesson3_homework.ui.CatalogActivity.Companion.IS_USER_AUTH
import com.example.lesson3_homework.ui.CatalogActivity.Companion.PRODUCT_ID
import com.example.lesson3_homework.ui.CatalogActivity.Companion.REQUEST_AUTH
import com.example.myapplication.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


class CheckoutActivity : BaseActivity(), BasketView {
    private val presenter = BasketPresenter()
    private var isAuth:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        setListeners()

        presenter.totalPricePrint()

        checkoutPriceValue.text="100"
        checkoutDiscountValue.text="10"
        checkoutSumValue.text="90"

        val productID = intent.extras?.getInt(PRODUCT_ID, -1)
        Log.d(tag, productID.toString())

        checkoutPayButton.setOnClickListener(){
            isAuth = true
            setResult(REQUEST_AUTH, Intent().apply{
                putExtra(IS_USER_AUTH, isAuth)
            })
        }
        checkoutBackBtn.setOnClickListener(){
            finish()
        }
    }

    private fun setListeners(){
        chechoutPersonSecondName.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                presenter.checkSecondName(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutPersonFirstName.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                presenter.checkFirstName(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutPersonMiddleName.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                presenter.checkMiddleName(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutPhone.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                presenter.checkPhone(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    override fun print(prices: String) {
//        Toast.makeText(this, "$prices", Toast.LENGTH_LONG).show()
        Log.d("Print", "$prices")
    }

    fun EditText.showError(visible:Boolean){
        val drawable = if (visible) R.drawable.ic_error
        else 0

        this.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
    }

    override fun showErrorForFirstName(visible: Boolean) {
        checkoutPersonFirstName.showError(visible)
    }

    override fun showErrorForMiddleName(visible: Boolean) {
        checkoutPersonMiddleName.showError(visible)
    }

    override fun showErrorForSecondName(visible: Boolean) {
        chechoutPersonSecondName.showError(visible)
    }

    override fun showErrorForPhone(visible: Boolean) {
        checkoutPhone.showError(visible)
    }
}
