package com.example.lesson3_homework.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson3_homework.domain.model.Product
import com.example.lesson3_homework.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_product.*
import kotlinx.android.synthetic.main.item_product.view.*

class BasketAdapter(
    private val onDeleteClick: (productName: String) -> Unit,
    private val onProductClick: (product: Product) -> Unit
): RecyclerView.Adapter<BasketAdapter.ViewHolder>() {

    private var products = listOf<Product>()

    fun setData(products: List<Product>){
        this.products = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketAdapter.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: BasketAdapter.ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    inner class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bind(product: Product) {
            productNameTv.text = product.productName
            productDiscountTv.text = product.salePercent.toString() + "%"
            productPriceTv.text = "%.2f Р".format(product.price)

            deleteProductIv.setOnClickListener{
                onDeleteClick(product.productName)
            }
            containerView.setOnClickListener {
                onProductClick(product)
            }
        }
    }
}