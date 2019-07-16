package com.fp.exc24

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na generowanie diamentu na podstawie podanej litery alfabetu
class Test {

    @Test
    fun tooLongInput() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) { Diamond("AA").showDiamond() }
        Assertions.assertEquals("Input must be exactly one letter", exception.message)
    }

    @Test
    fun otherThanLetter(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){Diamond("1").showDiamond()}
        Assertions.assertEquals("Input must be exactly one letter",exception.message)
    }

    @Test
    fun diamondA(){
        Assertions.assertEquals("A",Diamond("a").showDiamond())
    }

    @Test
    fun diamondB(){
        Assertions.assertEquals(" A \nB B\n A ",Diamond("B").showDiamond())
    }

    @Test
    fun diamondE(){
        Assertions.assertEquals(
                "    A    \n" +
                "   B B   \n" +
                "  C   C  \n" +
                " D     D \n" +
                "E       E\n" +
                " D     D \n" +
                "  C   C  \n" +
                "   B B   \n" +
                "    A    ",Diamond("E").showDiamond())
    }
}