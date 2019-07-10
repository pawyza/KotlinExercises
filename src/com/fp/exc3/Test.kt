package com.fp.exc3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//Zadaniem jest napisanie funkcji dokonującej transkrypcji
class Test{

    @Test
    fun noDNAGiven(){
        assertEquals("",transcript())
    }

    @Test
    fun dnaGiven1(){
        assertEquals("UGAC",transcript("ACTG"))
    }

    @Test
    fun dnaGiven2(){
        assertEquals("UAAUGCACA",transcript("ATTACGTGT"))
    }

    @Test
    fun emptyDNAGiven1(){
        assertEquals("",transcript(""))
    }
}