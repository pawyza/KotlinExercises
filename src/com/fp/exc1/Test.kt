package com.fp.exc1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//Zadanie polega na wstawieniu podanego stringa w określony miejsce w zdaniu
class Test {

    @Test
    fun noNameGiven(){
        assertEquals("One for you, one for me.", twofer())
    }

    @Test
    fun aliceNameGiven(){
        assertEquals("One for Alice, one for me.", twofer("Alice"))
    }

    @Test
    fun bobNameGiven(){
        assertEquals("One for Bob, one for me.", twofer("Bob"))
    }

    @Test
    fun emptyNameGiven(){
        assertEquals("One for , one for me.", twofer(""))
    }
}