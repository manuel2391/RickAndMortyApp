package com.mg.data.remote.response

import com.mg.common.api.Paging
import com.mg.domain.models.DCharacter

data class CharactersResponse(
    val info: Paging,
    val results:List<DCharacter>
)
