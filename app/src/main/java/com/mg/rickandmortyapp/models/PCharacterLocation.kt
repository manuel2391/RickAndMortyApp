package com.mg.rickandmortyapp.models

import android.os.Parcelable
import com.mg.domain.models.DCharacterLocation
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PCharacterLocation(
    val name:String,
    val url:String
):Parcelable

fun DCharacterLocation.toPresentation():PCharacterLocation =
    PCharacterLocation(
        this.name,
        this.url
    )