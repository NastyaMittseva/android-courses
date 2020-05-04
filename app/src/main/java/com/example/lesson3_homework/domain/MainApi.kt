package com.example.lesson3_homework.domain

import retrofit2.http.GET
import retrofit2.http.Path

data class RemoteProduct(
    val id: String,
    val name: String,
    val price: Double,
    val discountPercent: Int,
    val description: String,
    val imageUrl: String,
    val attributes: List<Attribute>
) {
    data class Attribute(
        val name: String,
        val value: String
    )
}

interface MainApi {
    @GET("products/all/{author}")
    suspend fun allProducts(@Path("author") author: String):List<RemoteProduct>
}