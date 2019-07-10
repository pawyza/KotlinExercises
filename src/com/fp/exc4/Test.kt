package com.fp.exc4

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

//funkcja ma sprawdzac czy podane zdanie to pangram, czyli zdanie zaiwerajace conajmniej jedna litere z calego alfabetu
// danego jezyka

class Test{

    @Test
    fun noSentenceTest(){
        assertFalse(checkIfPangram())
    }

    @Test
    fun emptySentenceTest(){
        assertFalse(checkIfPangram(""))
    }

    @Test
    fun alphabetTest(){
        assertTrue(checkIfPangram("abcdefghijklmnopqrstuvwxyz"))
    }

    @Test
    fun lowerCaseTest(){
        assertTrue(checkIfPangram("pack my box with five dozen liquor jugs"))
    }

    @Test
    fun upperCaseTest(){
        assertTrue(checkIfPangram("Pack my box with five dozen liquor jugs."))
    }

    @Test
    fun missingLettersTest(){
        assertFalse(checkIfPangram("Pack my box with five dozen liquor"))
    }
}