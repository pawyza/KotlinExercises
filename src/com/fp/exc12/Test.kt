package com.fp.exc12

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

//Zadanie polegające na generowaniu sekretnego powitania na podstawie zapisu binarnego liczby w zapisie dziesietnym na
//podstawie ponizszego schematu
//1 = wink
//10 = double blink
//100 = close your eyes
//1000 = jump
//10000 = Reverse the order of the operations in the secret handshake.
class Test{

    @Test
    fun toBigDecimal(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){Handshake(32)}
        Assertions.assertEquals("Cannot generate proper secret handshake",exception.message)
    }

    @Test
    fun wink(){
        Assertions.assertEquals("wink",Handshake(1).printHandshake())
    }

    @Test
    fun doubleBlink(){
        Assertions.assertEquals("double blink",Handshake(2).printHandshake())
    }

    @Test
    fun closeYourEyes(){
        Assertions.assertEquals("close your eyes",Handshake(4).printHandshake())
    }

    @Test
    fun jump(){
        Assertions.assertEquals("jump",Handshake(8).printHandshake())
    }

    @Test
    fun winkDoubleBlink(){
        Assertions.assertEquals("wink,double blink",Handshake(3).printHandshake())
    }

    @Test
    fun winkDoubleBlinkReversed(){
        Assertions.assertEquals("double blink,wink",Handshake(19).printHandshake())
    }

    @Test
    fun allPossibilities(){
        Assertions.assertEquals("jump,close your eyes,double blink,wink",Handshake(31).printHandshake())
    }
}