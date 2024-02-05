package com.maxbay.data.mappers

import com.maxbay.data.network.models.FeedbackNetwork
import com.maxbay.data.network.models.PriceNetwork
import com.maxbay.data.network.models.ProductNetwork
import com.maxbay.data.storage.models.ProductIsFavoriteModelStorage
import com.maxbay.domain.models.Feedback
import com.maxbay.domain.models.Price
import com.maxbay.domain.models.Product

internal fun List<ProductNetwork>.toDomain(
    productsIsFavorite: List<ProductIsFavoriteModelStorage>
): List<Product> {
    return this.map { productNetwork ->
        val isFavorite = productsIsFavorite.firstOrNull {
            it.id == productNetwork.id
        }?.isFavorite ?: false

        productNetwork.toDomain(isFavorite = isFavorite)
    }
}

private fun ProductNetwork.toDomain(isFavorite: Boolean) = Product(
    id = this.id,
    isFavorite = isFavorite,
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