package com.example.lesson3_homework.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson3_homework.R
import com.example.lesson3_homework.domain.model.Product
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_product_info.*

class ReviewedProductsAdapter (
    private val onProductClick: (product: Product) -> Unit
): RecyclerView.Adapter<ReviewedProductsAdapter.ViewHolder>() {
    private var products = listOf<Product>()

    fun setData(products: List<Product>){
        this.products = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewedProductsAdapter.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product_info, parent, false))

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ReviewedProductsAdapter.ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    inner class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bind(product: Product) {
            catalogLvProductNameTv.text = product.productName
            catalogLvProductPriceTv.text = "%.2f Р".format(product.price)

            containerView.setOnClickListener {
                onProductClick(product)
            }
        }
    }


}