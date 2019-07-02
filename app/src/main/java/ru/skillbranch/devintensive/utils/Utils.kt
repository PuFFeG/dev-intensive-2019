package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.models.User

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
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
        var inititals : String? = when(firstName){
            " " -> null
            "" -> null
            else -> firstName?.substring(0, 1)?.toUpperCase()?.trim()
        }
        when(lastName){
            " " -> null
            "" -> null
            null -> null
            else -> if(inititals == null)inititals = lastName?.substring(0,1)?.toUpperCase().trim() else inititals += lastName?.substring(0,1)?.toUpperCase().trim()
        }

        return inititals
    }
}