package ru.skillbranch.devintensive.extensions

import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(Pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = java.text.SimpleDateFormat(Pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND) : Date{
    var time = this.time

    time +=when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date: Date = Date()): String {
when(this.time){

    in date.time..Date().add(1, TimeUnits.SECOND).time -> return "только что"           //        0с - 1с "только что"
    in date.add(1, TimeUnits.SECOND).time..date.add(45, TimeUnits.SECOND).time -> return "несколько секунд назад"           //        1с - 45с "несколько секунд назад"
    in date.add(45, TimeUnits.SECOND).time..date.add(75, TimeUnits.SECOND).time -> return "минуту назад"          //    45с - 75с "минуту назад"
    in date.add(75, TimeUnits.SECOND).time..date.add(45, TimeUnits.MINUTE).time -> return "N минут назад"          //        75с - 45мин "N минут назад"
    in date.add(45, TimeUnits.MINUTE).time..date.add(75, TimeUnits.MINUTE).time -> return "час назад"          //    45мин - 75мин "час назад"
    in date.add(75, TimeUnits.MINUTE).time..date.add(22, TimeUnits.HOUR).time -> return "N часов назад"          //        75мин 22ч "N часов назад"
    in date.add(22, TimeUnits.HOUR).time..date.add(26, TimeUnits.HOUR).time -> return "день назад"          //    22ч - 26ч "день назад"
    in date.add(26, TimeUnits.HOUR).time..date.add(360, TimeUnits.DAY).time -> return "N дней назад"          //    26ч - 360д "N дней назад"
    in date.add(360, TimeUnits.DAY).time..date.add(6666, TimeUnits.DAY).time -> return "более года назад"          //            >360д "более года назад"

 //   in date.time..Date().add(1, TimeUnits.SECOND).time -> return "только что"           //        0с - 1с "только что"
 //   in date.add(1, TimeUnits.SECOND).time..date.add(45, TimeUnits.SECOND).time -> return "несколько секунд назад"           //        1с - 45с "несколько секунд назад"
 //   in date.add(45, TimeUnits.SECOND).time..date.add(75, TimeUnits.SECOND).time -> return "минуту назад"          //    45с - 75с "минуту назад"
 //   in date.add(75, TimeUnits.SECOND).time..date.add(45, TimeUnits.MINUTE).time -> return "N минут назад"          //        75с - 45мин "N минут назад"
 //   in date.add(45, TimeUnits.MINUTE).time..date.add(75, TimeUnits.MINUTE).time -> return "час назад"          //    45мин - 75мин "час назад"
 //   in date.add(75, TimeUnits.MINUTE).time..date.add(22, TimeUnits.HOUR).time -> return "N часов назад"          //        75мин 22ч "N часов назад"
 //   in date.add(22, TimeUnits.HOUR).time..date.add(26, TimeUnits.HOUR).time -> return "день назад"          //    22ч - 26ч "день назад"
 //   in date.add(26, TimeUnits.HOUR).time..date.add(360, TimeUnits.DAY).time -> return "N дней назад"          //    26ч - 360д "N дней назад"
 //   in date.add(360, TimeUnits.DAY).time..date.add(6666, TimeUnits.DAY).time -> return "более года назад"          //            >360д "более года назад"

    else -> return "${this.time} XXX    ${date.time} ${date.format()}"
}
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}