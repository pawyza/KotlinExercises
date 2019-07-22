package com.fp.exc40

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na napisanie programu sprawdzajacego poprawnosc kodu ISBN10 oraz ISBN13
class Test{

    @Test
    fun emptyISBN10(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){ISBN10.checkIfValid("")}
        Assertions.assertEquals("Not proper ISBN10 number",exception.message)
    }

    @Test
    fun emptyISBN13(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){ISBN13.checkIfValid("")}
        Assertions.assertEquals("Not proper ISBN13 number",exception.message)
    }

    @Test
    fun tooShortISBN10(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){ISBN10.checkIfValid("3-598-21508-")}
        Assertions.assertEquals("Not proper ISBN10 number",exception.message)
    }

    @Test
    fun tooShortISBN13(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){ISBN13.checkIfValid("978-83-01-00000-")}
        Assertions.assertEquals("Not proper ISBN13 number",exception.message)
    }

    @Test
    fun tooLongISBN10(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){ISBN10.checkIfValid("3-598-21508-11")}
        Assertions.assertEquals("Not proper ISBN10 number",exception.message)
    }

    @Test
    fun tooLongISBN13(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){ISBN13.checkIfValid("978-83-01-00000-11")}
        Assertions.assertEquals("Not proper ISBN13 number",exception.message)
    }

    @Test
    fun notISBN10(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){ISBN10.checkIfValid("3-598-21508-Q")}
        Assertions.assertEquals("Not proper ISBN10 number",exception.message)
    }

    @Test
    fun notSBN13(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){ISBN13.checkIfValid("978-83-01-00000-Q")}
        Assertions.assertEquals("Not proper ISBN13 number",exception.message)
    }

    @Test
    fun correctISBN10(){
        Assertions.assertTrue(ISBN10.checkIfValid("3-598-21508-8"))
    }

    @Test
    fun correctISBN13(){
        Assertions.assertTrue(ISBN13.checkIfValid("978-0-306-40615-7"))
    }

    @Test
    fun incorrectISBN10(){
        Assertions.assertFalse(ISBN10.checkIfValid("3-598-21508-X"))
    }

    @Test
    fun incorrectISBN13(){
        Assertions.assertFalse(ISBN13.checkIfValid("978-83-01-00000-3"))
    }
}