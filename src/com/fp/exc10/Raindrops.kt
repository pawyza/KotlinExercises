package com.fp.exc10

fun checkRaindrops(drops : Int) : String{
    require(drops >= 0){"Require positive integer"}

    /* All factors,but unnecessary
    val factors : MutableList<Int> = mutableListOf()

    for(i in 1..drops/2)
    {
        if(drops%i == 0) factors.add(i)
    }

    var result : String = ""
    if(factors.contains(3)) result = result.plus("Pling")
    if(factors.contains(5)) result = result.plus("Plang")
    if(factors.contains(7)) result = result.plus("Plong")
    */

    var result = ""
    if(drops%3 == 0) result = result.plus("Pling")
    if(drops%5 == 0) result = result.plus("Plang")
    if(drops%7 == 0) result = result.plus("Plong")

    return result
}