package com.example.lesson3_homework.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson3_homework.Basket
import com.example.lesson3_homework.Product
import com.example.lesson3_homework.R
import kotlinx.android.synthetic.main.item_product.view.*

class BasketAdapter(
    private val onDeleteClick: (string: String) -> Unit
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

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(product: Product) {
            itemView.productNameTv.text = product.getProductName()
            itemView.productDiscountTv.text = product.getProductSale().toString() + "%"
            itemView.productPriceTv.text = "%.2f Р".format(product.getProductPrice())

            itemView.deleteProductIv.setOnClickListener{
                onDeleteClick(product.getProductName())
            }
        }
    }
}