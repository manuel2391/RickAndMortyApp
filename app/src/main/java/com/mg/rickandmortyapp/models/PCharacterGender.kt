package com.mg.rickandmortyapp.models

import com.mg.domain.models.DCharacterGender

enum class PCharacterGender(val description:String) {
    MALE("Male"),
    FEMALE("Female"),
    GENDERLESS("Genderless"),
    UNKNOWN("Unknown");

    override fun toString(): String {
        return this.description
    }
}

fun DCharacterGender.toPresentation():PCharacterGender =
    when(this){
        DCharacterGender.MALE -> PCharacterGender.MALE
        DCharacterGender.FEMALE -> PCharacterGender.FEMALE
        DCharacterGender.GENDERLESS -> PCharacterGender.GENDERLESS
        DCharacterGender.UNKNOWN -> PCharacterGender.UNKNOWN
    }