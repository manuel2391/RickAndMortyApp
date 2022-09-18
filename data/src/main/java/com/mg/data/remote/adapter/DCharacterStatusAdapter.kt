package com.mg.data.remote.adapter

import com.mg.domain.models.DCharacterStatus
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.text.ParseException

class DCharacterStatusAdapter {

    @FromJson
    fun fromJson(status: String): DCharacterStatus? {
        try {
            return DCharacterStatus.getByName(status)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return null
    }

    @ToJson
    fun toJson(status: DCharacterStatus): String {
        return status.name
    }
}