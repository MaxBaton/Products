package com.maxbay.presentation.mappers

import com.maxbay.domain.models.Product
import com.maxbay.presentation.models.EMPTY_FEEDBACK_COUNT
import com.maxbay.presentation.models.EMPTY_FEEDBACK_RATING
import com.maxbay.presentation.models.ProductUi
import kotlinx.collections.immutable.toImmutableList

internal fun List<Product>.toUi() = this.map { it.toUi() }.toImmutableList()

private fun Product.toUi() = ProductUi(
    id = this.id,
    isFavorite = this.isFavorite,
    oldPrice = this.price.oldPrice,
    newPrice = this.price.newPrice,
    priceUnit = this.price.unit,
    priceDiscount = this.price.discount,
    title = this.title,
    subtitle = this.subtitle,
    feedbackCount = this.feedback?.count ?: EMPTY_FEEDBACK_COUNT,
    feedbackRating = this.feedback?.rating ?: EMPTY_FEEDBACK_RATING,
    tags = this.tags.toImmutableList()
)