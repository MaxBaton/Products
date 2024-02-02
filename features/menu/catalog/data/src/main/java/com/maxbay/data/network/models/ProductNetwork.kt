package com.maxbay.data.network.models

data class ProductNetwork(
    val available: Int,
    val description: String,
    val feedbackNetwork: FeedbackNetwork,
    val id: String,
    val infoNetwork: List<InfoNetwork>,
    val ingredients: String,
    val priceNetwork: PriceNetwork,
    val subtitle: String,
    val tags: List<String>,
    val title: String
)