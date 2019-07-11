package com.fp.exc10

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

//Zadanie polega na znajdywaniu liczb posiadajacych dzielnik 3,5 lub 7 i w zaleznosci od ich kombinacji generowniu
// wyniku w postaci lancucha znakow
class Test{

    @Test
    fun negativeNumber(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){ checkRaindrops(-1)}
        Assertions.assertEquals("Require positive integer",exception.message)
    }

    @Test
    fun noString(){
        assertEquals("", checkRaindrops(34))
    }

    @Test
    fun plingString(){
        assertEquals("Pling", checkRaindrops(9))
    }

    @Test
    fun plangString(){
        assertEquals("Plang", checkRaindrops(20))
    }

    @Test
    fun plongString(){
        assertEquals("Plong", checkRaindrops(28))
    }

    @Test
    fun plingPlangString(){
        assertEquals("PlingPlang", checkRaindrops(30))
    }

    @Test
    fun plangPlongString(){
        assertEquals("PlangPlong", checkRaindrops(35))
    }

    @Test
    fun plingPlangPlongString(){
        assertEquals("PlingPlangPlong", checkRaindrops(105))
    }
}