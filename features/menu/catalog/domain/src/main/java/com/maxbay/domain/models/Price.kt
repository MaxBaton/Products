package com.maxbay.domain.models

data class Price(
    val oldPrice: String,
    val newPrice: String,
    val unit: String,
    val discount: Int
)
