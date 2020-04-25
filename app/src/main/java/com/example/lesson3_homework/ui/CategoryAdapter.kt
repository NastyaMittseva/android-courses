package com.example.lesson3_homework.ui

import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson3_homework.R
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(
    private val onDeleteClick: (string: String) -> Unit
): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var categories: List<String> = listOf()

    fun setData(categories: List<String>){
        this.categories = categories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        )

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(text: String){
            itemView.categoryTv.text = text

            itemView.deleteIv.setOnClickListener{
                onDeleteClick(text)
            }

        }
    }
}