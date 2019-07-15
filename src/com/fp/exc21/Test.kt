package com.fp.exc21

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na napisaniu funkcji majacych na celu szyfrowanie oraz deszyfrowanie wiadomosci wedlug szyfru Atbash
class Test{

    @Test
    fun messageWithNumbersToCode(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){AtbashCipher.code("ACde12")}
        Assertions.assertEquals("Message cannot contain any digits",exception.message)
    }

    @Test
    fun messageWithNumbersToDecode(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){AtbashCipher.decode("ACde12")}
        Assertions.assertEquals("Message cannot contain any digits",exception.message)
    }

    @Test
    fun messageToCode(){
        Assertions.assertEquals("gvhggvhg",AtbashCipher.code("test test"))
    }

    @Test
    fun messageToDecode(){
        Assertions.assertEquals("testtest",AtbashCipher.decode("gvhg gvhg"))

    }
}