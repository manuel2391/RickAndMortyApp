package com.mg.domain.models

enum class DCharacterGender {
    MALE,FEMALE,GENDERLESS,UNKNOWN;

    companion object{
        fun getByName(name:String):DCharacterGender{
            return DCharacterGender.valueOf(name.uppercase())
        }
    }
}