package com.fp.exc38

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na pocieciu liczby na wszystkie mozliwe fragmenty o podanej dlugosci
class Test{

    @Test
    fun inputZero(){
        Assertions.assertEquals("0",NumberToSeries(0).displaySeriesOf(1))
    }

    @Test
    fun negativeInput(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){NumberToSeries(-1).displaySeriesOf(1)}
        Assertions.assertEquals("Number cannot be negative",exception.message)
    }

    @Test
    fun negativeWindow(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){NumberToSeries(1).displaySeriesOf(-1)}
        Assertions.assertEquals("Series cannot be negative or zero",exception.message)
    }

    @Test
    fun windowZero(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){NumberToSeries(1).displaySeriesOf(0)}
        Assertions.assertEquals("Series cannot be negative or zero",exception.message)
    }

    @Test
    fun windowOne(){
        Assertions.assertEquals("1 2 3 4 5",NumberToSeries(12345).displaySeriesOf(1))
    }

    @Test
    fun windowTwo(){
        Assertions.assertEquals("12 23 34 45",NumberToSeries(12345).displaySeriesOf(2))
    }

    @Test
    fun windowThree(){
        Assertions.assertEquals("123 234 345",NumberToSeries(12345).displaySeriesOf(3))
    }

    @Test
    fun windowOfInputSize(){
        Assertions.assertEquals("12345",NumberToSeries(12345).displaySeriesOf(5))
    }

    @Test
    fun windowBiggerThanInputSize(){
        Assertions.assertEquals("",NumberToSeries(12345).displaySeriesOf(6))
    }
}