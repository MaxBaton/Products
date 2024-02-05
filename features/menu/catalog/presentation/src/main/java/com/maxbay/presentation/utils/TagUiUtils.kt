package com.maxbay.presentation.utils

import com.maxbay.presentation.R
import com.maxbay.presentation.models.TagUi
import com.maxbay.presentation.models.tagsUi

internal fun List<String>.toTagsUi() = this.map { it.toTagUi() }

private fun String.toTagUi(): TagUi {
    val tagUiId = tagsUi.getOrDefault(this, R.string.tag_unknown)
    return TagUi(tagServer = this, tagUiId = tagUiId)
}