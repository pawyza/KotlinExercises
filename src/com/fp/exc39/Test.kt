package com.fp.exc39

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na stworzeniu programu szyfrujacego podany lancuch znakow wedlug szyfru rotacyjnego o podanym numerze
class Test {

    @Test
    fun noTextCoding(){
        Assertions.assertEquals("",RotationalCipher(10).codeText(""))
    }

    @Test
    fun noTextDecoding(){
        Assertions.assertEquals("",RotationalCipher(10).decodeText(""))
    }

    @Test
    fun textWithDigitsCoding(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){RotationalCipher(10).codeText("ab1")}
        Assertions.assertEquals("Message cannot contain any digits",exception.message)
    }

    @Test
    fun textWithDigitsDecoding(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){RotationalCipher(10).decodeText("1ab")}
        Assertions.assertEquals("Message cannot contain any digits",exception.message)
    }

    @Test
    fun lowerCaseTextCoding(){
        Assertions.assertEquals("bcd",RotationalCipher(1).codeText("abc"))
    }

    @Test
    fun lowerCaseTextDecoding(){
        Assertions.assertEquals("abc",RotationalCipher(1).decodeText("bcd"))
    }

    @Test
    fun upperCaseTextCoding(){
        Assertions.assertEquals("bcd",RotationalCipher(1).codeText("ABC"))
    }

    @Test
    fun upperCaseTextDecoding(){
        Assertions.assertEquals("abc",RotationalCipher(1).decodeText("BCD"))
    }

    @Test
    fun mixCaseTextCoding(){
        Assertions.assertEquals("bcd",RotationalCipher(1).codeText("a bC"))
    }

    @Test
    fun mixCaseTextDecoding(){
        Assertions.assertEquals("abc",RotationalCipher(1).decodeText("bC d"))
    }

    @Test
    fun negativeRotationCoding(){
        Assertions.assertEquals("bcd",RotationalCipher(-25).codeText("abc"))
    }

    @Test
    fun negativeRotationDecoding(){
        Assertions.assertEquals("abc",RotationalCipher(-25).decodeText("bcd"))
    }
}