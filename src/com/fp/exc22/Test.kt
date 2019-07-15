package com.fp.exc22

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na napisaniu funkcji zwracajacej n-ta liczbe pierwsza
class Test{

    @Test
    fun wrongNumber(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){ Prime.getPrime(0)}
        Assertions.assertEquals("Wrong n number",exception.message)
    }

    @Test
    fun nThPrime(){
        Assertions.assertEquals(2,Prime.getPrime(1))
        Assertions.assertEquals(3,Prime.getPrime(2))
        Assertions.assertEquals(5,Prime.getPrime(3))
        Assertions.assertEquals(7,Prime.getPrime(4))
        Assertions.assertEquals(11,Prime.getPrime(5))
        Assertions.assertEquals(13,Prime.getPrime(6))
    }
}