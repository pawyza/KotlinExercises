package com.fp.exc50

import java.lang.StringBuilder
import java.util.function.DoubleBinaryOperator
import kotlin.math.ceil
import kotlin.math.pow

object BaseChanger {

    var notations = Array<Char>(25){ i -> (65 + i).toChar()}

    fun changeToBaseOf(number : Int,base : Int) : String{
        val newNumber = StringBuilder()
        var translated = number
        var i = 0
        while(base*base.pow(i)<=translated) i++
        while(i != -1){
            val place = translated/base.pow(i)
            translated -= place * base.pow(i)
            newNumber.append(when(place > 9){true -> notations[place-10]; false -> place})
            i--
        }
        return newNumber.toString()
    }
    fun changeToIntBaseOfTen(number : String,base : Int) : Int{
        var intNumber = 0
        number.mapIndexed{i, c -> intNumber += when(notations.contains(c)){true -> notations.indexOf(c)+10; false -> Integer.valueOf(c.toString())}*base.pow(number.length-1-i)}
        return intNumber
    }

    private infix fun Int.pow(i : Int) : Int = this.toDouble().pow(i).toInt()
}