package com.fp.exc26

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na napisaniu funkcji majacej za zadanie zmiane listy zawierajacej wartosci calkowite oraz null oraz
// listy zagniezdzone zawierajace rowniez liczby calkowite oraz wartosci null, na liste zaierajaca jedynie wartosci integer
class Test{

    @Test
    fun emptyList(){
        Assertions.assertEquals(listOf<Int>(),Unpacker.unpackList(listOf<Any>()))
    }

    @Test
    fun notInteger(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {Unpacker.unpackList(listOf<Any>(1,2,"test"))}
        Assertions.assertEquals("Some of values are not integers or nulls", exception.message)
    }

    @Test
    fun onlyNull(){
        Assertions.assertEquals(listOf<Int>(),Unpacker.unpackList(listOf(null,null)))
    }

    @Test
    fun onlyIntegers(){
        Assertions.assertEquals(listOf(1,2,3),Unpacker.unpackList(listOf(1,2,3)))
    }

    @Test
    fun onlyNested(){
        Assertions.assertEquals(listOf(1,2),Unpacker.unpackList(listOf(listOf(1,null),listOf(2,null))))
    }

    @Test
    fun nestedInNested(){
        Assertions.assertEquals(listOf(1),Unpacker.unpackList(listOf(listOf(listOf(1,null),null))))
    }


    @Test
    fun mixValues(){
        Assertions.assertEquals(listOf(1,2,3),Unpacker.unpackList(listOf(1,listOf(2,null),listOf(listOf(3,null),null))))
    }

}