package com.fp.exc11

import kotlin.math.pow

fun getDifference(natNumber : Int = 0) : Int{
    require(natNumber >= 0){"Integer must be positive"}
    var squareOfSum = 0.0
    var sumOfSquare = 0.0
    for(i in 1..natNumber){
        println(i)
        squareOfSum += i
        sumOfSquare += i.toDouble().pow(2.0)
    }
    return (squareOfSum.pow(2.0) - sumOfSquare).toInt()
}