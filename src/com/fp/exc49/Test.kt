package com.fp.exc49

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import java.lang.IllegalArgumentException

//Program generujacy mape do gry saper
class Test {

    @Test
    fun tooSmallSize(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){Minesweeper(0)}
        Assertions.assertEquals("Size must be positive number!",exception.message)
    }

    @Test
    fun randomField(){
        Minesweeper(1).showFullMap()
        Minesweeper(2).showFullMap()
        Minesweeper(5).showFullMap()
    }
}
