package com.mg.domain.models

data class DCharacterFilter(
    val page:Int? = null,
    val name:String? = null,
    val status:String? = null,
    val species:String? = null,
    val type:String? = null,
    val gender:String? = null
)
