package com.fp.exc36

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

//Zadanie polegajace na wygenerowaniu trojkata Pascala o podanej ilosci rzedow
class Test{

    @Test
    fun negativeNumberOfRows(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){PascalTriangleGenerator.showTriangleOfRows(-1)}
        Assertions.assertEquals("Rows number can't be negative",exception.message)
    }

    @Test
    fun zeroOfRows(){
        Assertions.assertEquals("",PascalTriangleGenerator.showTriangleOfRows(0))
    }

    @Test
    fun oneRow(){
        Assertions.assertEquals("1",PascalTriangleGenerator.showTriangleOfRows(1))
    }

    @Test
    fun twoRows(){
        Assertions.assertEquals(" 1\n" +
                "1 1",PascalTriangleGenerator.showTriangleOfRows(2))
    }

    @Test
    fun fiveRows(){
        Assertions.assertEquals("    1\n" +
                "   1 1\n" +
                "  1 2 1\n" +
                " 1 3 3 1\n" +
                "1 4 6 4 1",PascalTriangleGenerator.showTriangleOfRows(5))
    }
}