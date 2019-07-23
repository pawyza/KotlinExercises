package com.fp.exc44

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na przepisaniu punktacji gry scrabble z formatu Map<Int,List<String>>
//na format Map<String,Int>
class Test{

    val exampleOldSystemMap = mapOf(
        1 to listOf("A", "E", "I", "O", "U", "L", "N", "R", "S", "T"),
        2 to listOf("D", "G"),
        3 to listOf("B", "C", "M", "P"),
        4 to listOf("F", "H", "V", "W", "Y"),
        5 to listOf("K"),
        8 to listOf("J","X"),
        10 to listOf("Q","Z")
    )

    @Test
    fun showScoreSystem(){
        Assertions.assertEquals("a for 1 points\n" +
                "e for 1 points\n" +
                "i for 1 points\n" +
                "o for 1 points\n" +
                "u for 1 points\n" +
                "l for 1 points\n" +
                "n for 1 points\n" +
                "r for 1 points\n" +
                "s for 1 points\n" +
                "t for 1 points\n" +
                "d for 2 points\n" +
                "g for 2 points\n" +
                "b for 3 points\n" +
                "c for 3 points\n" +
                "m for 3 points\n" +
                "p for 3 points\n" +
                "f for 4 points\n" +
                "h for 4 points\n" +
                "v for 4 points\n" +
                "w for 4 points\n" +
                "y for 4 points\n" +
                "k for 5 points\n" +
                "j for 8 points\n" +
                "x for 8 points\n" +
                "q for 10 points\n" +
                "z for 10 points",ETL(exampleOldSystemMap).showScoreSystem())
    }
}