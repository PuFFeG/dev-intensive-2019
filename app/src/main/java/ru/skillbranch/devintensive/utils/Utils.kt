package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.models.User

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        //todo fix me GREEEEN
        val parts : List<String>? = when(fullName)
        {
            " " -> null
            "" -> null
            else -> fullName?.split(" ")
        }
        val firstName =parts?.getOrNull(0)
        val lastName =parts?.getOrNull(1)
        //return Pair(firstName,lastName)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider:String = ""): String {
return "ZZZZZ"
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
return "XXXX"
    }
}