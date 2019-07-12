package com.fp.exc15

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException


//Zadanie polegajace na uzyciu algorytmu Luhn'a do oceny czy podany numer jest prawidlowy
class Test {

    @Test
    fun toShortNumber() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) { LuhnAlgorithm("0") }
        Assertions.assertEquals("Number must be longer than 1", exception.message)
    }

    @Test
    fun containsLetters() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) { LuhnAlgorithm("014A 34B4") }
        Assertions.assertEquals("There are other signs than numbers in given number", exception.message)
    }


    @Test
    fun incorrectNumber() {
        Assertions.assertEquals(false, LuhnAlgorithm("8273 1232 7352 0569").result)
    }

    @Test
    fun correctNumber() {
        Assertions.assertEquals(true, LuhnAlgorithm("4539 1488 0343 6467").result)
    }
}