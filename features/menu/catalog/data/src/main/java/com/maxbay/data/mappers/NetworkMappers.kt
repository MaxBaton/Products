package com.maxbay.data.mappers

import com.maxbay.data.network.models.FeedbackNetwork
import com.maxbay.data.network.models.PriceNetwork
import com.maxbay.data.network.models.ProductNetwork
import com.maxbay.domain.models.Feedback
import com.maxbay.domain.models.Price
import com.maxbay.domain.models.Product

internal fun List<ProductNetwork>.toDomain() = this.map { it.toDomain() }

private fun ProductNetwork.toDomain() = Product(
    id = this.id,
    isFavorite = false,
    price = this.priceNetwork.toDomain(),
    title = this.title,
    subtitle = this.subtitle,
    feedback = this.feedbackNetwork.toDomain(),
    tags = this.tags
)

private fun PriceNetwork.toDomain() = Price(
    oldPrice = this.price,
    newPrice = this.priceWithDiscount,
    unit = this.unit,
    discount = this.discount
)

private fun FeedbackNetwork.toDomain() = Feedback(
    count = this.count,
    rating = this.rating
)