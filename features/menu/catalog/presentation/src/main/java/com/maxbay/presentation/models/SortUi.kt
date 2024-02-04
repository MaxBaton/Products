package com.maxbay.presentation.models

import androidx.annotation.StringRes
import com.maxbay.domain.models.SortOrder
import com.maxbay.presentation.R

data class SortOrderUi(
    val sortCode: Int,
    @StringRes
    val titleId: Int
)

internal val sortOrdersUi = mapOf(
    SortOrder.POPULAR.ordinal to R.string.sort_popular,
    SortOrder.PRICE_DESC.ordinal to R.string.sort_price_desc,
    SortOrder.PRICE_ASC.ordinal to R.string.sort_price_asc
)