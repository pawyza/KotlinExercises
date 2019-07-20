package com.fp.exc33

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

//Zadanie polegajace na szukaniu czynników pierwszych podanej liczby
class Test {

    @Test
    fun negativeNumber(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){PrimeFactorsFinder.findAllPrimeFactors(-1)}
        Assertions.assertEquals("Input must be bigger than 2",exception.message)
    }

    @Test
    fun toLowNumber(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){PrimeFactorsFinder.findAllPrimeFactors(1)}
        Assertions.assertEquals("Input must be bigger than 2",exception.message)
    }

    @Test
    fun findingPrimeFactors(){
        Assertions.assertEquals(listOf(2),PrimeFactorsFinder.findAllPrimeFactors(2))
        Assertions.assertEquals(listOf(2,2),PrimeFactorsFinder.findAllPrimeFactors(4))
        Assertions.assertEquals(listOf(2,2,3,5),PrimeFactorsFinder.findAllPrimeFactors(60))
        Assertions.assertEquals(listOf(2,2,53,101),PrimeFactorsFinder.findAllPrimeFactors(21412))
    }
}