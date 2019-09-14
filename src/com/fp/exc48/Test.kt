package com.fp.exc48

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na napisaniu algorytmu wykonujacego wyszukiwanie binarne
class Test {

    @Test
    fun noElementsList(){
        Assertions.assertEquals(-1,BinarySearch.search(listOf<Int>(),1))
    }

    @Test
    fun oneElementList(){
        Assertions.assertEquals(0,BinarySearch.search(listOf(6),6))
    }

    @Test
    fun twoElementsList(){
        Assertions.assertEquals(1,BinarySearch.search(listOf(6,3),6))
    }

    @Test
    fun tenElementsListFistHalf(){
        Assertions.assertEquals(1,BinarySearch.search(listOf(10,9,8,7,6,5,4,3,2,1),2))
    }

    @Test
    fun tenElementsListSecondHalf(){
        Assertions.assertEquals(8,BinarySearch.search(listOf(10,9,8,7,6,5,4,3,2,1),9))
    }

    @Test
    fun elevenElementsListFirstHalf(){
        Assertions.assertEquals(1,BinarySearch.search(listOf(11,10,9,8,7,6,5,4,3,2,1),2))
    }

    @Test
    fun elevenElementsListSecondHalf(){
        Assertions.assertEquals(9,BinarySearch.search(listOf(11,10,9,8,7,6,5,4,3,2,1),10))
    }

    @Test
    fun smallerThanSmallestElement(){
        Assertions.assertEquals(-1,BinarySearch.search(listOf(10,9,8,7,6,5,4,3,2,1),0))
    }

    @Test
    fun biggerThanBiggestElement(){
        Assertions.assertEquals(-1,BinarySearch.search(listOf(10,9,8,7,6,5,4,3,2,1),11))
    }
}