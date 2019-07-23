package com.fp.exc42

import java.lang.IllegalArgumentException
import kotlin.math.floor
import java.lang.Math.pow
import kotlin.math.roundToInt

object RomanNumerals {
    private val romanNum = mapOf(
        1 to "I",
        5 to "V",
        10 to "X",
        50 to "L",
        100 to "C",
        500 to "D",
        1000 to "M"
    )

    private fun byPower(number: Int): Array<Int> = Array(4) { i -> (floor(number / pow(10.0, i.toDouble())) - floor(number / pow(10.0, (i+1).toDouble()))*10).roundToInt()}

    private fun romanNotation(number : Int,power : Int) : String = when(number){
        0 -> ""
        1 -> romanNum.get(1*pow(10.0,power.toDouble()).toInt()) as String
        2 -> romanNum.get(1*pow(10.0,power.toDouble()).toInt())!!.repeat(2)
        3 -> romanNum.get(1*pow(10.0,power.toDouble()).toInt())!!.repeat(3)
        4 -> romanNum.get(1*pow(10.0,power.toDouble()).toInt())+romanNum.get(5*pow(10.0,power.toDouble()).toInt()) as String
        5 -> romanNum.get(5*pow(10.0,power.toDouble()).toInt()) as String
        6 -> romanNum.get(5*pow(10.0,power.toDouble()).toInt())+romanNum.get(1*pow(10.0,power.toDouble()).toInt()) as String
        7 -> romanNum.get(5*pow(10.0,power.toDouble()).toInt())+romanNum.get(1*pow(10.0,power.toDouble()).toInt())!!.repeat(2)
        8 -> romanNum.get(5*pow(10.0,power.toDouble()).toInt())+romanNum.get(1*pow(10.0,power.toDouble()).toInt())!!.repeat(3)
        9 -> romanNum.get(1*pow(10.0,power.toDouble()).toInt())+romanNum.get(1*pow(10.0,(power+1).toDouble()).toInt()) as String
        else -> throw IllegalArgumentException("Error while converting")
        }


    fun convertToRoman(number : Int): String{
        require(number>0){"Negative numbers are not supported"}
        require(number<=3000){"Numbers bigger than 3000 are not supported"}
        return byPower(number).reversed().mapIndexed{p, n -> romanNotation(n,3-p)}.joinToString("")
    }

}