package com.mg.domain.models

data class DCharacter(
    val id:Int,
    val name:String,
    val status:DCharacterStatus,
    val species:String,
    val type:String,
    val gender:DCharacterGender,
    val image:String,
    val created:String,
    val origin:DCharacterLocation,
    val location:DCharacterLocation
)
