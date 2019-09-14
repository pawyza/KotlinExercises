package com.fp.exc51

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Program przedstawiajacy podana liczbe w postaci tekstowej
class Test{

    @Test
    fun sayTestSimple() {
        Assertions.assertEquals("zero", NumberConstructor.say(0))
        Assertions.assertEquals("three", NumberConstructor.say(3))
        Assertions.assertEquals("twenty-one", NumberConstructor.say(21))
    }

    @Test
    fun sayTestHundreds(){
        Assertions.assertEquals("one hundred",NumberConstructor.say(100))
        Assertions.assertEquals("one hundred ten",NumberConstructor.say(110))
        Assertions.assertEquals("one hundred twenty-one",NumberConstructor.say(121))
        Assertions.assertEquals("two hundred",NumberConstructor.say(200))
        Assertions.assertEquals("two hundred ten",NumberConstructor.say(210))
        Assertions.assertEquals("two hundred twenty-one",NumberConstructor.say(221))
    }

    @Test
    fun sayTestThousands(){
        Assertions.assertEquals("one thousand",NumberConstructor.say(1000))
        Assertions.assertEquals("two thousand two hundred",NumberConstructor.say(2200))
        Assertions.assertEquals("two thousand two hundred ten",NumberConstructor.say(2210))
        Assertions.assertEquals("two thousand two hundred twenty-one",NumberConstructor.say(2221))
        Assertions.assertEquals("two hundred thousand two hundred",NumberConstructor.say(200_200))
        Assertions.assertEquals("two hundred ten thousand two hundred ten",NumberConstructor.say(210_210))
        Assertions.assertEquals("two hundred twenty-one thousand two hundred twenty-one",NumberConstructor.say(221_221))
    }

    @Test
    fun sayTestMillions(){
        Assertions.assertEquals("one million",NumberConstructor.say(1_000_000))
        Assertions.assertEquals("two million two thousand two hundred",NumberConstructor.say(2_002_200))
        Assertions.assertEquals("two million two thousand two hundred ten",NumberConstructor.say(2_002_210))
        Assertions.assertEquals("two million two thousand two hundred twenty-one",NumberConstructor.say(2_002_221))
        Assertions.assertEquals("two million two hundred thousand two hundred",NumberConstructor.say(2_200_200))
        Assertions.assertEquals("two million two hundred ten thousand two hundred ten",NumberConstructor.say(2_210_210))
        Assertions.assertEquals("two million two hundred twenty-one thousand two hundred twenty-one",NumberConstructor.say(2_221_221))
        Assertions.assertEquals("two hundred million two hundred thousand two hundred",NumberConstructor.say(200_200_200))
        Assertions.assertEquals("two hundred ten million two hundred ten thousand two hundred ten",NumberConstructor.say(210_210_210))
        Assertions.assertEquals("two hundred twenty-one million two hundred twenty-one thousand two hundred twenty-one",NumberConstructor.say(221_221_221))
    }

    @Test
    fun sayTestBillions() {
        Assertions.assertEquals("one billion",NumberConstructor.say(1_000_000_000))
        Assertions.assertEquals("one billion two million two thousand two hundred",NumberConstructor.say(1_002_002_200))
        Assertions.assertEquals("one billion two million two thousand two hundred ten",NumberConstructor.say(1_002_002_210))
        Assertions.assertEquals("one billion two million two thousand two hundred twenty-one",NumberConstructor.say(1_002_002_221))
        Assertions.assertEquals("one billion two million two hundred thousand two hundred",NumberConstructor.say(1_002_200_200))
        Assertions.assertEquals("one billion two million two hundred ten thousand two hundred ten",NumberConstructor.say(1_002_210_210))
        Assertions.assertEquals("one billion two million two hundred twenty-one thousand two hundred twenty-one",NumberConstructor.say(1_002_221_221))
        Assertions.assertEquals("one billion two hundred million two hundred thousand two hundred",NumberConstructor.say(1_200_200_200))
        Assertions.assertEquals("one billion two hundred ten million two hundred ten thousand two hundred ten",NumberConstructor.say(1_210_210_210))
        Assertions.assertEquals("one billion two hundred twenty-one million two hundred twenty-one thousand two hundred twenty-one",NumberConstructor.say(1_221_221_221))
    }
}