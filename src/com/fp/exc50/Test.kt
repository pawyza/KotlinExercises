package com.fp.exc50

import org.junit.jupiter.api.Test

//Program zmieniajacy system liczbowy na wskazany
class Test{

    @Test
    fun binaryNotationTest(){
        println(BaseChanger.changeToBaseOf(1,2))
        println(BaseChanger.changeToBaseOf(2,2))
        println(BaseChanger.changeToBaseOf(10,2))
    }

    @Test
    fun ternaryNotationTest(){
        println(BaseChanger.changeToBaseOf(2,3))
        println(BaseChanger.changeToBaseOf(3,3))
        println(BaseChanger.changeToBaseOf(10,3))
    }

    @Test
    fun octalNotationTest(){
        println(BaseChanger.changeToBaseOf(4,8))
        println(BaseChanger.changeToBaseOf(8,8))
        println(BaseChanger.changeToBaseOf(10,8))
    }

    @Test
    fun decimalNotationTest(){
        println(BaseChanger.changeToBaseOf(1,10))
        println(BaseChanger.changeToBaseOf(10,10))
        println(BaseChanger.changeToBaseOf(100,10))
    }

    @Test
    fun hexadecimalNotationTest(){
        println(BaseChanger.changeToBaseOf(10,16))
        println(BaseChanger.changeToBaseOf(15,16))
        println(BaseChanger.changeToBaseOf(16,16))
        println(BaseChanger.changeToBaseOf(100,16))
    }

    @Test
    fun binaryToDecimalNotationTest(){
        println(BaseChanger.changeToIntBaseOfTen("1",2))
        println(BaseChanger.changeToIntBaseOfTen("10",2))
        println(BaseChanger.changeToIntBaseOfTen("1010",2))
    }

    @Test
    fun ternaryToDecimalNotationTest(){
        println(BaseChanger.changeToIntBaseOfTen("2",3))
        println(BaseChanger.changeToIntBaseOfTen("10",3))
        println(BaseChanger.changeToIntBaseOfTen("101",3))
    }

    @Test
    fun octalToDecimalNotationTest(){
        println(BaseChanger.changeToIntBaseOfTen("4",8))
        println(BaseChanger.changeToIntBaseOfTen("10",8))
        println(BaseChanger.changeToIntBaseOfTen("12",8))
    }

    @Test
    fun decimalToDecimalNotationTest(){
        println(BaseChanger.changeToIntBaseOfTen("1",10))
        println(BaseChanger.changeToIntBaseOfTen("10",10))
        println(BaseChanger.changeToIntBaseOfTen("100",10))
    }

    @Test
    fun hexadecimalToDecimalNotationTest(){
        println(BaseChanger.changeToIntBaseOfTen("8",16))
        println(BaseChanger.changeToIntBaseOfTen("10",16))
        println(BaseChanger.changeToIntBaseOfTen("A",16))
        println(BaseChanger.changeToIntBaseOfTen("F",16))
        println(BaseChanger.changeToIntBaseOfTen("64",16))
    }


}