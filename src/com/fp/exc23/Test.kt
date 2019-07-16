package com.fp.exc23

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

//Zadanie polegajace na szukaniu punktow siodlowych podanych macierzy
class Test{

    @Test
    fun emptyRows(){
        var exception = Assertions.assertThrows(IllegalArgumentException::class.java){SaddlePoints.matrix = arrayOf()}
        Assertions.assertEquals("Array cannot be empty",exception.message)
        exception = Assertions.assertThrows(IllegalArgumentException::class.java){SaddlePoints.matrix = arrayOf(intArrayOf(),intArrayOf())}
        Assertions.assertEquals("Array cannot be empty",exception.message)
    }

    @Test
    fun unequalLengths(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){SaddlePoints.matrix = arrayOf(intArrayOf(1,2,3,4),intArrayOf(2,3,4))}
        Assertions.assertEquals("Rows must be equal length",exception.message)
    }

    @Test
    fun tooBigArrays(){
        val list = mutableListOf<IntArray>()
        for(i in 0 ..1000) {
            list.add(IntArray(1000) { e -> e})
        }
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){SaddlePoints.matrix = list.toTypedArray()}
        Assertions.assertEquals("Input matrix is to big",exception.message)
    }

    @Test
    fun displayTest(){
        SaddlePoints.matrix = arrayOf(intArrayOf(0))
        println()
        println(SaddlePoints.displayMatrix())

        SaddlePoints.matrix = arrayOf(intArrayOf(1,2),intArrayOf(2,3))
        println()
        println(SaddlePoints.displayMatrix())

        SaddlePoints.matrix = arrayOf(intArrayOf(1,2,3),intArrayOf(2,3,4))
        println()
        println(SaddlePoints.displayMatrix())

        SaddlePoints.matrix = arrayOf(intArrayOf(1,2),intArrayOf(2,3),intArrayOf(1,2))
        println()
        println(SaddlePoints.displayMatrix())
    }

    @Test
    fun displayBigMatrixTest(){
        val list = mutableListOf<IntArray>()
            for(i in 0 ..200) {
                list.add(IntArray(200) { e -> e})
            }
        SaddlePoints.matrix = list.toTypedArray()
        print(SaddlePoints.displayMatrix())
    }

    @Test
    fun saddlePoints(){
        SaddlePoints.matrix = arrayOf(intArrayOf(2,1),intArrayOf(2,3))
        Assertions.assertEquals("x: 0 y: 0 e: 2",SaddlePoints.displaySaddlePoints())


        SaddlePoints.matrix = arrayOf(intArrayOf(9,8,7),intArrayOf(5,3,2), intArrayOf(6,6,7))
        Assertions.assertEquals("x: 0 y: 1 e: 5",SaddlePoints.displaySaddlePoints())

        SaddlePoints.matrix = arrayOf(intArrayOf(4,3,5,1,2),intArrayOf(-1,0,-2,0,-1), intArrayOf(-4,1,4,3,5), intArrayOf(-3,0,-1,0,-2), intArrayOf(3,2,-7,3,8))
        Assertions.assertEquals("x: 1 y: 1 e: 0\n" +
                "x: 3 y: 1 e: 0\n" +
                "x: 1 y: 3 e: 0\n" +
                "x: 3 y: 3 e: 0",SaddlePoints.displaySaddlePoints())
    }
}