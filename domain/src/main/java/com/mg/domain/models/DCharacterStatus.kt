package com.mg.domain.models

import java.util.*

enum class DCharacterStatus {
    ALIVE,DEAD,UNKNOWN;

    companion object{
        fun getByName(name:String):DCharacterStatus{
            return DCharacterStatus.valueOf(name.uppercase(Locale.ROOT))
        }
    }

}