package com.fp.exc8

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

//Zadanie polega na generowanie akronimow podanych zdan
class Test{

    @Test
    fun noSentence(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){getAcronym()}
        Assertions.assertEquals("Cannot generate acronym without proper sentence", exception.message)
    }

    @Test
    fun emptySentence(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){getAcronym("")}
        Assertions.assertEquals("Cannot generate acronym without proper sentence",exception.message)
    }

    @Test
    fun oneWordSentence(){
        assertEquals("T", getAcronym("Test"))
    }

    @Test
    fun allUpperCaseSentence(){
        assertEquals("TAC", getAcronym("TESTING ACRONYM CHECKER"))
    }

    @Test
    fun allLowerCaseSentence(){
        assertEquals("TAC", getAcronym("testing acronym checker"))
    }

    @Test
    fun mixCaseSentence(){
        assertEquals("TAC", getAcronym("Testing acronym checker"))
    }

    @Test
    fun sentenceWithPunctation(){
        assertEquals("TTAC", getAcronym("Testing. Testing acronym checker."))
    }
}