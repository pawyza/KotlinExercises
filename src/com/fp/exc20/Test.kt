package com.fp.exc20

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajacy na wyznaczeniu krokow dla problemu Collatza dla podanej liczby dodatniej
class Test{

    @Test
    fun negativeNumber(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){CollatzConjecture().calculateSteps(0)}
        Assertions.assertEquals("Number must be positive",exception.message)
    }

    @Test
    fun numberOne() {
        Assertions.assertEquals(listOf(1),CollatzConjecture().calculateSteps(1))
    }

    @Test
    fun positiveNumber(){
        Assertions.assertEquals(listOf(1, 2, 4, 8, 16, 5, 10, 3, 6, 12),CollatzConjecture().calculateSteps(12))
    }

    @Test
    fun bigPositiveNumber(){
        Assertions.assertEquals(listOf(1, 2, 4, 8, 16, 5, 10, 20, 40, 13, 26, 52, 17, 34, 11, 22, 44, 88, 176, 352, 704, 1408, 469, 938, 1876, 625, 1250, 2500, 5000, 10000),CollatzConjecture().calculateSteps(10000))
    }
}