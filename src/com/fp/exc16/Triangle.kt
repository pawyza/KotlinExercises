package com.fp.exc16

import kotlin.math.pow
import kotlin.math.sqrt

class Triangle (sides : Array<Int>){

    var triangleType : TriangleType = TriangleType.NONE
    var areaSize = 0.0

    init {
        for (i in 0..2)
            require(sides.sum() - sides[i] >= sides[i]){"The sum of the lengths of any two sides must be greater than or equal to the length of the remaining side"}
        triangleType = getType(sides)
        areaSize = 1.0/4.0 * sqrt(sides.map{ s -> s.toDouble().pow(2)}.sum().pow(2) - 2 * sides.map{ s -> s.toDouble().pow(4)}.sum())
    }

    private fun getType(sides : Array<Int>) : TriangleType{
        if(sides[0] == sides[1] && sides[1] == sides[2]) return TriangleType.EQUILATERAL
        else if(sides[0] == sides[1] || sides[1] == sides[2] || sides[0] == sides[2])  return TriangleType.ISOSCELES
        else {
            for (i in 0..2)
                if (sides.sum() - 2*sides[i] == 0) return TriangleType.DEGENERATE
            return TriangleType.SCALENE
        }
    }

    fun getRoundedArea() : Double = (areaSize * 1000).toInt().toDouble()/1000
}

enum class TriangleType{
    EQUILATERAL, ISOSCELES, SCALENE, DEGENERATE, NONE
}