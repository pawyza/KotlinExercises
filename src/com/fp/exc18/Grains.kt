package com.fp.exc18

import java.math.BigInteger
import kotlin.math.pow

class Grains {

    val chessboard : Array<BigInteger> = (0 until 64).toList().map{i -> BigInteger.TWO.pow(i)}.toTypedArray()

    fun getGrainsOnSquare(square : Int) : BigInteger{
        require(square in 1..64){"Wrong square number"}
        return chessboard[square-1]
    }

    fun getGrainsTotalGrains(square : Int) : BigInteger{
        require(square in 1..64){"Wrong square number"}
        var sum : BigInteger = BigInteger.ZERO
        for(i in 0 until square) {
            sum = sum.add(chessboard[i])
        }
        return sum
    }
}