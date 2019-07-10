package com.fp.exc5

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//Zadanie polega na dokonaniu testu hamminga 2 ciagow DNA, test ocenia ilosc roznic pomiedzy ciagami znakow
class Test {

    @Test
    fun noDNAGiven() {
        assertEquals(0, hammingDif())
    }

    @Test
    fun oneDNAGiven() {
        assertEquals(4, hammingDif(dna1 = "ATCG"))
    }

    @Test
    fun otherDNAGiven() {
        assertEquals(4, hammingDif(dna2 = "ATCG"))
    }

    @Test
    fun sameDNAGiven() {
        assertEquals(0, hammingDif(dna2 = "ATCG",dna1 = "ATCG"))
    }

    @Test
    fun differentDNAGiven() {
        assertEquals(2, hammingDif(dna2 = "ACTG",dna1 = "ATCG"))
    }

    @Test
    fun differentLenDNAGiven() {
        assertEquals(4, hammingDif(dna2 = "ACTG",dna1 = "ATCGGG"))
    }


    @Test
    fun completelyDefDNAGiven() {
        assertEquals(4, hammingDif(dna2 = "GCTA",dna1 = "ATCG"))
    }

    @Test
    fun noDNAGivenv2() {
        assertEquals(0, hammingDifv2())
    }

    @Test
    fun oneDNAGivenv2() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) { hammingDifv2(dna1 = "ATCG")}
        Assertions.assertEquals("left and right strands must be of equal length.",exception.message)
    }

    @Test
    fun otherDNAGivenv2() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) { hammingDifv2(dna2 = "ATCG")}
        Assertions.assertEquals("left and right strands must be of equal length.",exception.message)
    }

    @Test
    fun sameDNAGivenv2() {
        assertEquals(0, hammingDifv2(dna2 = "ATCG",dna1 = "ATCG"))
    }

    @Test
    fun differentDNAGivenv2() {
        assertEquals(2, hammingDifv2(dna2 = "ACTG",dna1 = "ATCG"))
    }

    @Test
    fun differentLenDNAGivenv2() {
       val exception = Assertions.assertThrows(IllegalArgumentException::class.java) { hammingDifv2(dna2 = "ATCG",dna1 = "ATCGGG")}
        Assertions.assertEquals("left and right strands must be of equal length.",exception.message)
    }

    @Test
    fun completelyDefDNAGivenv2() {
        assertEquals(4, hammingDifv2(dna2 = "GCTA",dna1 = "ATCG"))
    }
}