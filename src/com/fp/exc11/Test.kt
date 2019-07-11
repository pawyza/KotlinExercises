package com.fp.exc11

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException


//Zadanie polega na otrzymaniu roznicy pomiedzy kwadratowi sumy, a suma kwadratow N kolejnych liczb naturalnych
class Test{

    @Test
    fun negativeNumber(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){ getDifference(-1)}
        Assertions.assertEquals("Integer must be positive", exception.message)
    }

    @Test
    fun noNumber(){
        Assertions.assertEquals(0,getDifference(0))
    }

    @Test
    fun one(){
        Assertions.assertEquals(0,getDifference(1))
    }

    @Test
    fun two(){
        Assertions.assertEquals(4,getDifference(2))
    }

    @Test
    fun oten(){
        Assertions.assertEquals(2640,getDifference(10))
    }
}