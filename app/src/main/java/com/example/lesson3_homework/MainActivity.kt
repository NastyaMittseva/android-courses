package com.example.lesson3_homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BasketView {
    private val presenter = BasketPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        setListeners()

        presenter.totalPricePrint()

        checkoutPriceValue.text="100"
        checkoutDiscountValue.text="10"
        checkoutSumValue.text="90"
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
