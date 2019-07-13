package com.fp.exc18

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import java.math.BigInteger

//Zadanie polegajace na stworzeniu tablicy zawierajacej 64 elementy ciagu 2^x, na podstawie ktorej istnieje mozliwosc
// wyswietlenia wartosci konkretnego elementu ciagu lub sumy elementow ciagu wlacznie z wybranym elementem
class Test{

    @Test
    fun toLowNumberSquaresGrains(){
        val g = Grains()
        val exception =
            Assertions.assertThrows(IllegalArgumentException::class.java) {g.getGrainsOnSquare(0) }
        Assertions.assertEquals("Wrong square number", exception.message)
    }

    @Test
    fun toLowNumberTotalGrains(){
        val g = Grains()
        val exception =
            Assertions.assertThrows(IllegalArgumentException::class.java) { g.getGrainsTotalGrains(0) }
        Assertions.assertEquals("Wrong square number", exception.message)
    }

    @Test
    fun toBigNumberSquaresGrains(){
        val g = Grains()
        val exception =
            Assertions.assertThrows(IllegalArgumentException::class.java) { g.getGrainsOnSquare(65) }
        Assertions.assertEquals("Wrong square number", exception.message)
    }

    @Test
    fun toBigNumberTotalGrains(){
        val g = Grains()
        val exception =
            Assertions.assertThrows(IllegalArgumentException::class.java) { g.getGrainsTotalGrains(65) }
        Assertions.assertEquals("Wrong square number", exception.message)
    }

    @Test
    fun grainsOnSquare(){
        val g = Grains()
        Assertions.assertEquals(BigInteger.valueOf(1),g.getGrainsOnSquare(1))
        Assertions.assertEquals(BigInteger.valueOf(2),g.getGrainsOnSquare(2))
        Assertions.assertEquals(BigInteger.valueOf(4),g.getGrainsOnSquare(3))
        Assertions.assertEquals(BigInteger.valueOf(8),g.getGrainsOnSquare(4))
        Assertions.assertEquals(BigInteger.TWO.pow(63), g.getGrainsOnSquare(64))
    }

    @Test
    fun totalGrains(){
        val g = Grains()
        Assertions.assertEquals(BigInteger.valueOf(1),g.getGrainsTotalGrains(1))
        Assertions.assertEquals(BigInteger.valueOf(3),g.getGrainsTotalGrains(2))
        Assertions.assertEquals(BigInteger.valueOf(7),g.getGrainsTotalGrains(3))
        Assertions.assertEquals(BigInteger.valueOf(15),g.getGrainsTotalGrains(4))
    }
}