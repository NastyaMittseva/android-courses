package com.example.lesson3_homework

import com.example.lesson3_homework.ui.CatalogView
import moxy.MvpPresenter

class CatalogPresenter: MvpPresenter<CatalogView>() {
    private val list = mutableListOf("Телевизоры", "Телефоны", "Планшеты", "Часы", "Компьютеры", "Ноутбуки")

    fun setData(){
        viewState.setCategories(list)
    }

    fun removeItem(category: String){
        val position = list.indexOf(category)
        list.remove(category)
        viewState.removeItem(position)
    }
}