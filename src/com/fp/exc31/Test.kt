package com.fp.exc31

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

//Zadanie polegajace na wygenerowaniu spirali o podanych wymiarach skladajacej sie z kolejnych liczb
class Test{

    @Test
    fun spiralOfSizeMinusOne(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){SpiralGenerator.displaySpiral(-1)}
        Assertions.assertEquals("Size must be positive number",exception.message)
    }

    @Test
    fun spiralOfSizeZero(){
        Assertions.assertEquals("",SpiralGenerator.displaySpiral(0))
    }

    @Test
    fun spiralOfSizeOne(){
        Assertions.assertEquals("1",SpiralGenerator.displaySpiral(1))
    }

    @Test
    fun spiralOfSizeTwo(){
        Assertions.assertEquals("1 2\n" +
                "4 3",SpiralGenerator.displaySpiral(2))
    }

    @Test
    fun spiralOfSizeThree(){
        Assertions.assertEquals("1 2 3\n" +
                "8 9 4\n" +
                "7 6 5",SpiralGenerator.displaySpiral(3))
    }

    @Test
    fun spiralOfSizeFive(){
        Assertions.assertEquals("1 2 3 4 5\n" +
                "16 17 18 19 6\n" +
                "15 24 25 20 7\n" +
                "14 23 22 21 8\n" +
                "13 12 11 10 9",SpiralGenerator.displaySpiral(5))
    }

    @Test
    fun spiralOfSizeTen(){
        Assertions.assertEquals("1 2 3 4 5 6 7 8 9 10\n" +
                "36 37 38 39 40 41 42 43 44 11\n" +
                "35 64 65 66 67 68 69 70 45 12\n" +
                "34 63 84 85 86 87 88 71 46 13\n" +
                "33 62 83 96 97 98 89 72 47 14\n" +
                "32 61 82 95 100 99 90 73 48 15\n" +
                "31 60 81 94 93 92 91 74 49 16\n" +
                "30 59 80 79 78 77 76 75 50 17\n" +
                "29 58 57 56 55 54 53 52 51 18\n" +
                "28 27 26 25 24 23 22 21 20 19",SpiralGenerator.displaySpiral(10))
    }
}