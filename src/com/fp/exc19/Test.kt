package com.fp.exc19

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

//Zadanie polegajace na otrzymaniu wszystkich liczb pierwszych do wskazanej liczby pierwszej wykorzystujac w tym celu sito Erathosthenesa
class Test{

    @Test
    fun negativeNumber(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){ getAllPrimes(-1)}
        Assertions.assertEquals("Given number is to small",exception.message)
    }

    @Test
    fun tooSmallNumber(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){ getAllPrimes(1)}
        Assertions.assertEquals("Given number is to small",exception.message)
    }

    @Test
    fun firstPrime(){
        Assertions.assertEquals(setOf(2), getAllPrimes(2))
    }

    @Test
    fun primeNumbersTen(){
        Assertions.assertEquals(setOf(2, 3, 5, 7), getAllPrimes(10))
    }

    @Test
    fun primeNumbersHundred(){
        Assertions.assertEquals(setOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97), getAllPrimes(100))
    }
}