package com.fp.exc2

fun leapYearChecker(date : Int = -1) : Boolean = (date%4 == 0 && date%100 !=0) || (date%100 == 0 && date%400 == 0)