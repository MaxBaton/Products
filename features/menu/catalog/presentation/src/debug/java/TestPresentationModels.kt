import com.maxbay.presentation.R
import com.maxbay.presentation.models.ProductUi
import kotlinx.collections.immutable.immutableListOf
import kotlinx.collections.immutable.toImmutableList

internal val testProductUi = ProductUi(
    id = "1",
    isFavorite = false,
    oldPrice = "23",
    newPrice = "12",
    priceUnit = "$",
    priceDiscount = 35,
    title = "Product",
    subtitle = "subtitle",
    feedbackCount = 23,
    feedbackRating = 4.56,
    tags = listOf("body", "face").toImmutableList(),
    iconIds = listOf(R.drawable.item_1, R.drawable.item_2).toImmutableList()
)