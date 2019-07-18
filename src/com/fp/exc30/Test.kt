package com.fp.exc30

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na podzieleniu tekstu na zdania, a nastepnie policzeniu wystapien kazdego ze slow w danym zdaniu
class Test{

    @Test
    fun incorrectGen(){
        var exception = Assertions.assertThrows(IllegalArgumentException::class.java) {WordCounter.displayAllSentencesWords("")}
        Assertions.assertEquals("Text cannot be empty", exception.message)
        exception = Assertions.assertThrows(IllegalArgumentException::class.java) {WordCounter.displayAllSentencesWords("  ")}
        Assertions.assertEquals("Text cannot be empty", exception.message)
    }

    @Test
    fun oneSentenceWithoutPunctuation(){
        Assertions.assertEquals("olly olly in come free\nolly: 2\nin: 1\ncome: 1\nfree: 1",WordCounter.displayAllSentencesWords("olly olly in come free"))
    }

    @Test
    fun oneSentenceWithPunctuation(){
        Assertions.assertEquals("Olly, olly in come free.\nOlly: 1\nolly: 1\nin: 1\ncome: 1\nfree: 1",WordCounter.displayAllSentencesWords("Olly, olly in come free."))
    }

    @Test
    fun moreSentencesWithoutPunctuation(){
        Assertions.assertEquals("olly olly in come free\n" +
                "olly: 2\n" +
                "in: 1\n" +
                "come: 1\n" +
                "free: 1\n" +
                "olly olly in come free\n" +
                "olly: 2\n" +
                "in: 1\n" +
                "come: 1\n" +
                "free: 1\n" +
                "oly oly in come free\n" +
                "oly: 2\n" +
                "in: 1\n" +
                "come: 1\n" +
                "free: 1",WordCounter.displayAllSentencesWords("olly olly in come free. olly olly in come free! oly oly in come free."))
    }

    @Test
    fun moreSentencesWithPunctuation(){
        Assertions.assertEquals("Olly, olly in come free\n" +
                "Olly: 1\n" +
                "olly: 1\n" +
                "in: 1\n" +
                "come: 1\n" +
                "free: 1\n" +
                "Olly, olly in come free\n" +
                "Olly: 1\n" +
                "olly: 1\n" +
                "in: 1\n" +
                "come: 1\n" +
                "free: 1\n" +
                "Oly, oly in come free\n" +
                "Oly: 1\n" +
                "oly: 1\n" +
                "in: 1\n" +
                "come: 1\n" +
                "free: 1",WordCounter.displayAllSentencesWords("Olly, olly in come free. Olly, olly in come free!  Oly, oly in come free."))
    }
}