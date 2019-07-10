package com.fp.exc9

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import kotlin.test.assertEquals

//Zadanie polega na wygenerowaniu punktacji dla podanego slowa wedlug listy punktow za litere gry scrabble
class Test {
    @Test
    fun noWord() {
        val exception =
            Assertions.assertThrows(IllegalArgumentException::class.java) { ScrabbleChecker().evaluateWord() }
        Assertions.assertEquals("No word given", exception.message)
    }

    @Test
    fun emptyWord() {
        val exception =
            Assertions.assertThrows(IllegalArgumentException::class.java) { ScrabbleChecker().evaluateWord("") }
        Assertions.assertEquals("No word given", exception.message)
    }

    @Test
    fun allUpperCaseWord() {
        assertEquals(4, ScrabbleChecker().evaluateWord("test"))
    }

    @Test
    fun allLowerCaseWord() {
        assertEquals(4, ScrabbleChecker().evaluateWord("TEST"))
    }

    @Test
    fun mixCaseWord() {
        assertEquals(4, ScrabbleChecker().evaluateWord("tEsT"))
    }

    @Test
    fun longWord() {
        assertEquals(14, ScrabbleChecker().evaluateWord("beverage"))
    }

    @Test
    fun unsupportedLetters() {
        val exception =
            Assertions.assertThrows(IllegalStateException::class.java) { ScrabbleChecker().evaluateWord("test7") }
        assertEquals("Word contains unsupported letters or signs", exception.message)
    }
}