package com.maxbay.data.network.models

import com.google.gson.annotations.SerializedName

data class ProductNetwork(
    @SerializedName(value = "available")
    val available: Int,
    @SerializedName(value = "description")
    val description: String,
    @SerializedName(value = "feedback")
    val feedbackNetwork: FeedbackNetwork,
    @SerializedName(value = "id")
    val id: String,
    @SerializedName(value = "info")
    val infoNetwork: List<InfoNetwork>,
    @SerializedName(value = "ingredients")
    val ingredients: String,
    @SerializedName(value = "price")
    val priceNetwork: PriceNetwork,
    @SerializedName(value = "subtitle")
    val subtitle: String,
    @SerializedName(value = "tags")
    val tags: List<String>,
    @SerializedName(value = "title")
    val title: String
)