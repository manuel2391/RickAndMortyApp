package com.mg.data.remote.adapter

import com.mg.domain.models.DCharacterGender
import com.mg.domain.models.DCharacterStatus
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.text.ParseException

class DCharacterGenderAdapter {

    @FromJson
    fun fromJson(status: String): DCharacterGender? {
        try {
            return DCharacterGender.getByName(status)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return null
    }

    @ToJson
    fun toJson(status: DCharacterGender): String {
        return status.name
    }
}