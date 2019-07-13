package com.fp.exc17

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

//Zadanie polegajace na otrzymaniu najwiekszej sumy serii kolejnych cyfr o podanej dlugosci z podanego lancucha znakow
class Test {

    @Test
    fun wrongInput() {
        val exception =
            Assertions.assertThrows(IllegalArgumentException::class.java) { LargestSeries("123a") }
        Assertions.assertEquals("Input contains other signs than digits", exception.message)
    }

    @Test
    fun tooLongSeries() {
        val exception =
            Assertions.assertThrows(IllegalArgumentException::class.java) { LargestSeries("123").getLargesrSeriesOf(4) }
        Assertions.assertEquals("Series is too long", exception.message)
    }

    @Test
    fun tooShortSeries() {
        val exception =
            Assertions.assertThrows(IllegalArgumentException::class.java) { LargestSeries("123").getLargesrSeriesOf(0) }
        Assertions.assertEquals("Series is too short", exception.message)
    }

    @Test
    fun wholeInput() {
        Assertions.assertEquals(3,LargestSeries("111").getLargesrSeriesOf(3))
    }

    @Test
    fun exampleSeries() {
        Assertions.assertEquals(4,LargestSeries("1234").getLargesrSeriesOf(1))
        Assertions.assertEquals(14,LargestSeries("68311").getLargesrSeriesOf(2))
        Assertions.assertEquals(17,LargestSeries("68311").getLargesrSeriesOf(3))
        Assertions.assertEquals(11,LargestSeries("18311").getLargesrSeriesOf(2))
    }
}