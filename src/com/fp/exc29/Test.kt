package com.fp.exc29

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na policzeniu ilosci wystapien kazdego nukleotydu w odcinku DNA
class Test{

    @Test
    fun incorrectGen(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {NucleotideCounter.displayNucleotides("AACG3T")}
        Assertions.assertEquals("Genes cannot contain numbers", exception.message)
    }

    @Test
    fun correctGen(){
        Assertions.assertEquals("A: 2\nT: 1\nC: 1\nG: 1\nother: 0", NucleotideCounter.displayNucleotides("AACGT"))
    }

    @Test
    fun withUndefinedNucleotidesGen(){
        //Geny moga zawierac rozne oznaczenia takie jak np. N, gdy nukleotyd w konkretnym miejscu jest niezidentyfikowany
        // lub obecnosc konkretnego nukleotydu nie jest pewna
        Assertions.assertEquals("A: 3\nT: 2\nC: 1\nG: 1\nother: 7", NucleotideCounter.displayNucleotides("ANNACNTAGNNTKJ"))
    }
}