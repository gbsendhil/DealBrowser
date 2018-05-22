package com.target.sendhil.deals.model

data class Response(
    val _id: String,
    val data: List<Data>,
    val type: String
)

data class Data(
    val _id: String,
    val aisle: String,
    val description: String,
    val guid: String,
    val image: String,
    val index: Int,
    val price: String,
    val salePrice: String,
    val title: String
)