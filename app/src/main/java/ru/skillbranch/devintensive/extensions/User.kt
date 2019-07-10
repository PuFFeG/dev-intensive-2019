package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import ru.skillbranch.devintensive.extensions.humanizeDiff

import java.util.*

fun User.toUserView() : UserView{
    val nickname = Utils.transliteration("$firstName, $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if(lastVisit == null) "Еще ни разу не был" else if (isOnline) "online" else "Последний раз был} " //${lastVisit.humanizeDiff()
    return UserView(
        id,
        fullName = "$firstName $lastName",
        avatar = avatar,
        nickname = nickname,
        initials = initials,
        status = status
        )
}

fun String.stripHtml(): String? = this.replace("[\\s]+".toRegex(), " ").replace(Regex("<(/?[^>]+)>"),"").replace(Regex("&(.+);"),"")

fun String.truncate(value:Int=16):String{
    if(this.length-1<=value)
        return this
    val result = this.trimStart().substring(0,value+1)
    if (result[result.length-1].isWhitespace()){
        return result.trim()}
    if(value+2<=this.length-1&&this.trimStart()[value+2].isWhitespace()){
        return result
    }
    else return "$result..."
}
