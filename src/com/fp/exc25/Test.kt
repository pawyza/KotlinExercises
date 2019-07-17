package com.fp.exc25

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na sprawdzeniu czy podane slowo jest isogramem
class Test{

    @Test
    fun withNumbers(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {Isogram.isIsogram("2words")}
        Assertions.assertEquals("Cannot contain numbers", exception.message)
    }

    @Test
    fun withSpace(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {Isogram.isIsogram("two words")}
        Assertions.assertEquals("Cannot contain spaces", exception.message)
    }

    @Test
    fun properIsogram(){
        Assertions.assertTrue(Isogram.isIsogram("isogram"))
        Assertions.assertTrue(Isogram.isIsogram("lumberjacks"))
        Assertions.assertTrue(Isogram.isIsogram("background"))
    }

    @Test
    fun notIsogram(){
        Assertions.assertFalse(Isogram.isIsogram("isograms"))
        Assertions.assertFalse(Isogram.isIsogram("test"))
    }

    @Test
    fun withOtherSigns(){
        Assertions.assertTrue(Isogram.isIsogram("six-year-old"))
    }

    @Test
    fun withBigLetters(){
        Assertions.assertTrue(Isogram.isIsogram("Downstream"))
    }
}