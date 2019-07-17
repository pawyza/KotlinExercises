package com.fp.exc27

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na stworzeniu programu szyfrujacego oraz deszyfrujacego podany tekst wedlug Fence Cipher
class Test {

    @Test
    fun emptyTextEncoding(){
        Assertions.assertEquals("",FenceCipherEncoder(3).encode(""))
    }

    @Test
    fun emptyTextDecoding(){
        Assertions.assertEquals("",FenceCipherEncoder(3).decode(""))
    }

    @Test
    fun encodeText(){
        Assertions.assertEquals("WECRLTEERDSOEEFEAOCAIVDEN",FenceCipherEncoder(3).encode("WE ARE DISCOVERED FLEE AT ONCE"))
        Assertions.assertEquals("WCLEESOFECAIVDENRDEEAOERT",FenceCipherEncoder(5).encode("WE ARE DISCOVERED FLEE AT ONCE"))
    }

    @Test
    fun decodeText(){
        Assertions.assertEquals("WEAREDISCOVEREDFLEEATONCE",FenceCipherEncoder(3).decode("WECRLTEERDSOEEFEAOCAIVDEN"))
        Assertions.assertEquals("WEAREDISCOVEREDFLEEATONCE",FenceCipherEncoder(5).decode("WCLEESOFECAIVDENRDEEAOERT"))
    }
}