package com.fp.exc16

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

//Zadanie polegajace na sprawdzeniu typu trojkata na podstawie jego bokow
class Test{

    @Test
    fun wrongSides(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){Triangle(arrayOf(1,4,9))}
        Assertions.assertEquals("The sum of the lengths of any two sides must be greater than or equal to the length of the remaining side",exception.message)
    }

    @Test
    fun equilateralTriangle(){
        val tri = Triangle(arrayOf(3,3,3))
        Assertions.assertEquals(TriangleType.EQUILATERAL,tri.triangleType)
        Assertions.assertEquals(3.897,tri.getRoundedArea())
    }

    @Test
    fun isoscelesTriangle(){
        val tri = Triangle(arrayOf(3,3,4))
        Assertions.assertEquals(TriangleType.ISOSCELES,tri.triangleType)
        Assertions.assertEquals(4.472,tri.getRoundedArea())
    }

    @Test
    fun scaleneTriangle(){
        val tri = Triangle(arrayOf(2,3,4))
        Assertions.assertEquals(TriangleType.SCALENE,tri.triangleType)
        Assertions.assertEquals(2.904,tri.getRoundedArea())
    }

    @Test
    fun degenerateTriangle(){
        val tri = Triangle(arrayOf(1,2,3))
        Assertions.assertEquals(TriangleType.DEGENERATE,tri.triangleType)
        Assertions.assertEquals(0.0,tri.getRoundedArea())
    }
}