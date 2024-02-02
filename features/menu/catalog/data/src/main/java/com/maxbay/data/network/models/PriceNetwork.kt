package com.maxbay.data.network.models

data class PriceNetwork(
    val discount: Int,
    val price: String,
    val priceWithDiscount: String,
    val unit: String
)