package com.maxbay.presentation.models

import com.maxbay.presentation.R
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

internal val productIcons = mapOf<String, ImmutableList<Int>>(
    "cbf0c984-7c6c-4ada-82da-e29dc698bb50" to listOf(R.drawable.item_1, R.drawable.item_5).toImmutableList(),
    "54a876a5-2205-48ba-9498-cfecff4baa6e" to listOf(R.drawable.item_1, R.drawable.item_2).toImmutableList(),
    "75c84407-52e1-4cce-a73a-ff2d3ac031b3" to listOf(R.drawable.item_5, R.drawable.item_6).toImmutableList(),
    "16f88865-ae74-4b7c-9d85-b68334bb97db" to listOf(R.drawable.item_3, R.drawable.item_5).toImmutableList(),
    "26f88856-ae74-4b7c-9d85-b68334bb97db" to listOf(R.drawable.item_2, R.drawable.item_3).toImmutableList(),
    "15f88865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.item_1, R.drawable.item_6).toImmutableList(),
    "88f88865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.item_3, R.drawable.item_4).toImmutableList(),
    "55f58865-ae74-4b7c-9d81-b78334bb97db" to listOf(R.drawable.item_1, R.drawable.item_5).toImmutableList()
)