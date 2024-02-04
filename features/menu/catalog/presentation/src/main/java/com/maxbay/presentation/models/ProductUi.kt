package com.maxbay.presentation.models

import kotlinx.collections.immutable.ImmutableList

internal const val EMPTY_FEEDBACK_COUNT = 0
internal const val EMPTY_FEEDBACK_RATING = 0.0

data class ProductUi(
    val id: String,
    val isFavorite: Boolean,
    val oldPrice: String,
    val newPrice: String,
    val priceUnit: String,
    val priceDiscount: Int,
    val title: String,
    val subtitle: String,
    val feedbackCount: Int,
    val feedbackRating: Double,
    val tags: ImmutableList<String>,
    val iconIds: ImmutableList<Int>
)