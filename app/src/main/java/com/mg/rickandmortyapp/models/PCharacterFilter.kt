package com.mg.rickandmortyapp.models

import com.mg.domain.models.DCharacterFilter

data class PCharacterFilter(
    val lastPage:Boolean = false,
    val page:Int = 1,
    val name:String? = null,
    val status:PCharacterStatus? = null,
    val species:String? = null,
    val type:String? = null,
    val gender:PCharacterGender? = null

){
    fun toDomain():DCharacterFilter = DCharacterFilter(
        this.page,
        this.name,
        this.status?.name,
        this.species,
        this.type,
        this.gender?.name
    )
}


