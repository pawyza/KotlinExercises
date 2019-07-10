package com.fp.exc2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/*Zadanie polega na rozpoznaniu na podstawie podanego roku czy jest on przestępny czy nie
Rok przestepny:
- podzielny przez 4
- wyjatek lata podzielne przez 100, z wyjatkie tych podzielnych przez 400
*/

class Test{

    @Test
    fun noDateGiven(){
        assertEquals(false, leapYearChecker())
    }

    @Test
    fun normalDatesGive(){
        assertEquals(false, leapYearChecker(2019))
        assertEquals(false, leapYearChecker(1900))
        assertEquals(false, leapYearChecker(1997))
    }

    @Test
    fun leapDatesGiven(){
        assertEquals(true, leapYearChecker(2000))
        assertEquals(true, leapYearChecker(1996))
        assertEquals(true, leapYearChecker(2020))
    }
}