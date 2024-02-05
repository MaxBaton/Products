package com.maxbay.presentation.models

import androidx.annotation.StringRes
import com.maxbay.presentation.R

internal const val TAG_ALL = "all"


data class TagUi(
    val tagServer: String,
    @StringRes
    val tagUiId: Int
)

internal val tagsUi = mapOf(
    TAG_ALL to R.string.tag_all,
    "body" to R.string.tag_body,
    "face" to R.string.tag_face,
    "mask" to R.string.tag_mask,
    "suntan" to R.string.tag_suntan
)
