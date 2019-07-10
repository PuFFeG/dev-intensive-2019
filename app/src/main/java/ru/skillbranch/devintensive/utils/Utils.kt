package ru.skillbranch.devintensive.utils

import android.icu.text.Transliterator
import ru.skillbranch.devintensive.models.User
import java.math.BigDecimal
import java.math.BigInteger

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
    fun transliteration(payload: String, divider: String = " "): String {
/**
        var result = ""
        payload.replace(" ", divider)
            .toCharArray()
            .forEach {
                val symbol = map.getOrDefault(it.toLowerCase(), it.toString())
                result += if (it.isUpperCase()) symbol.capitalize() else symbol
            }
        return result
        */
        return ""
    }
    /**
    fun transliteration2(payload: String, divider: String = " ") : String {

        // first clear provided text fragment from " and whitespaces
        val clearCharArr = strArray.toCharArray()
            .filter { i -> !i.isWhitespace() }
            .filter { i -> !i.equals('"') }

        // then make array of transliteration pairs
        val pairs = clearCharArr.joinToString("").split(",")

        // then make HashMap
        var lettersMap: MutableMap<String, String> = mutableMapOf()
        pairs.forEach{ pair ->
            var let = (pair.split(":"))
            lettersMap.put( let[0].toString(), let[1].toString()  )
        }

        // then expand our HashMap for capital letters
        for(i in 0..pairs.size-1) {
            val pair = pairs[i].split(":")
            lettersMap.put(  pair[0].toString().capitalize(),
                pair[1].toString().capitalize() )
        }

        return payload.split("").map { str ->
            if( lettersMap.containsKey(str) ) lettersMap.get(str) else str
        }
            .joinToString("")
            .split(" ")
            .joinToString(divider)
    }
    */


    fun toInitials(firstName: String?, lastName: String?): String? {
                var inititals: String? = when (firstName) {
                    " ", ""  -> null
                    else -> firstName?.substring(0, 1)?.toUpperCase()?.trim()
                }
                when (lastName) {
                    " ", "", null -> null
                    else -> if (inititals == null) inititals =
                        lastName.substring(0, 1).toUpperCase().trim() else inititals += lastName.substring(0, 1)
                        ?.toUpperCase().trim()
                }

                return inititals
            }
        }
