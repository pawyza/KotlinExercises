package com.fp.exc28

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na stworzeniu funkcji majacej na celu formatowanie amerykanskiego numeru telefonu zapisanego w roznych formatach do postaci jedynie liczb
class Test {

    @Test
    fun worngCC(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {NumberFormatter.formatNumber("+2 (113)-195-0253")}
        Assertions.assertEquals("Wrong regional number", exception.message)
    }

    @Test
    fun wrongGrouping(){
        var exception = Assertions.assertThrows(IllegalArgumentException::class.java) {NumberFormatter.formatNumber("613 9950 253")}
        Assertions.assertEquals("Incorrect number, wrong digits grouping or too many digits", exception.message)
        exception = Assertions.assertThrows(IllegalArgumentException::class.java) {NumberFormatter.formatNumber("6139950253")}
        Assertions.assertEquals("Incorrect number, wrong digits grouping or too many digits", exception.message)
        exception = Assertions.assertThrows(IllegalArgumentException::class.java) {NumberFormatter.formatNumber("61399502531")}
        Assertions.assertEquals("Incorrect number, wrong digits grouping or too many digits", exception.message)
    }

    @Test
    fun wrongNumber(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {NumberFormatter.formatNumber("+1 (113)-195-0253")}
        Assertions.assertEquals("Incorrect number", exception.message)
    }


    @Test
    fun correctNumbers(){
        Assertions.assertEquals("6139950253",NumberFormatter.formatNumber("+1 (613)-995-0253"))
        Assertions.assertEquals("6139950253",NumberFormatter.formatNumber("613-995-0253"))
        Assertions.assertEquals("6139950253",NumberFormatter.formatNumber("1 613 995 0253"))
        Assertions.assertEquals("6139950253",NumberFormatter.formatNumber("613.995.0253"))
    }
}