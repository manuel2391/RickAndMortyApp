package com.mg.rickandmortyapp.models

import android.os.Parcelable
import com.mg.domain.models.DCharacter
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PCharacter(
    val id:Int,
    val name:String,
    val status: PCharacterStatus,
    val species:String,
    val type:String,
    val gender: PCharacterGender,
    val image:String,
    val created:String,
    val origin: PCharacterLocation,
    val location: PCharacterLocation
):Parcelable{
    val isDead:Boolean
        get() = status == PCharacterStatus.DEAD
}

fun DCharacter.toPresentation(): PCharacter =
    PCharacter(
        this.id,
        this.name,
        this.status.toPresentation(),
        this.species,
        this.type,
        this.gender.toPresentation(),
        this.image,
        this.created,
        this.origin.toPresentation(),
        this.location.toPresentation()
    )
