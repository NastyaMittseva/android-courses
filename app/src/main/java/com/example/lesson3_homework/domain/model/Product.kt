package com.example.lesson3_homework.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Product(
    /**
     * Must be positive
     */
    val id: Long,
    val productName: String,
    val price: Double,
    val salePercent: Int = 0
): Parcelable {
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
}