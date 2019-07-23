package com.fp.exc42

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

//Zadanie polegajace na napisaniu programu konwertujacego licze na zapis rzymski
class Test{

    @Test
    fun negativeNumber(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){RomanNumerals.convertToRoman(-1)}
        Assertions.assertEquals("Negative numbers are not supported",exception.message)
    }

    @Test
    fun tooBigNumber(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){RomanNumerals.convertToRoman(3001)}
        Assertions.assertEquals("Numbers bigger than 3000 are not supported",exception.message)
    }

    @Test
    fun romanNumber(){
        Assertions.assertEquals("I",RomanNumerals.convertToRoman(1))
        Assertions.assertEquals("V",RomanNumerals.convertToRoman(5))
        Assertions.assertEquals("X",RomanNumerals.convertToRoman(10))
        Assertions.assertEquals("L",RomanNumerals.convertToRoman(50))
        Assertions.assertEquals("C",RomanNumerals.convertToRoman(100))
        Assertions.assertEquals("D",RomanNumerals.convertToRoman(500))
        Assertions.assertEquals("M",RomanNumerals.convertToRoman(1000))
        Assertions.assertEquals("MMM",RomanNumerals.convertToRoman(3000))
        Assertions.assertEquals("MMVIII",RomanNumerals.convertToRoman(2008))
        Assertions.assertEquals("MCMXC",RomanNumerals.convertToRoman(1990))
    }
}