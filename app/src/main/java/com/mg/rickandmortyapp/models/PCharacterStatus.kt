package com.mg.rickandmortyapp.models

import com.mg.domain.models.DCharacterStatus

enum class PCharacterStatus(val description:String) {
    ALIVE("Alive"),
    DEAD("Dead"),
    UNKNOWN("Unknown");

    override fun toString(): String {
        return this.description
    }
}

fun DCharacterStatus.toPresentation():PCharacterStatus =
    when(this){
        DCharacterStatus.ALIVE -> PCharacterStatus.ALIVE
        DCharacterStatus.DEAD -> PCharacterStatus.DEAD
        DCharacterStatus.UNKNOWN -> PCharacterStatus.UNKNOWN
    }