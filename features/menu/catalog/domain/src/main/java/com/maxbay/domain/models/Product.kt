package com.maxbay.domain.models

data class Product(
    val id: String,
    val isFavorite: Boolean,
    val price: Price,
    val title: String,
    val subtitle: String,
    val feedback: Feedback?,
    val tags: List<String>
)