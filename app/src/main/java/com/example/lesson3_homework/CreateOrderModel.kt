package com.example.lesson3_homework

/*
*  Модель для создания заказа.
*/
data class CreateOrderModel(
    var firstName:String = "",
    var secondName: String = "",
    var middleName: String = "",
    var phone: String = ""
)