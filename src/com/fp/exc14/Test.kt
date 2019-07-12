package com.fp.exc14

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

//Zadanie polega na wygnerowania sumy wielokrotnosci podanych liczb mniejszych od podanej innej liczby
class Test{

    @Test
    fun toBigMultiples(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){SumOfMultiples(setOf(6),4)}
        Assertions.assertEquals("One or more multiples are bigger than number",exception.message)
    }

    @Test
    fun oneMultiple(){
        Assertions.assertEquals(9,SumOfMultiples(setOf(3),9).getMultiplesSum())
    }


    @Test
    fun twoMultiples(){
        Assertions.assertEquals(78,SumOfMultiples(setOf(3,5),20).getMultiplesSum())
    }
}