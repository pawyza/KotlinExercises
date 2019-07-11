package com.fp.exc13

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

//Zadanie polega na klasyfikacji podanych liczb wedlug schematu Nicomachus'a
class Test{

    @Test
    fun negativeNumber() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){NicomachusClassification().classify(-1)}
        Assertions.assertEquals("Number must be positive",exception.message)
    }

    @Test
    fun perfectNumbers(){
        Assertions.assertEquals("Perfect",NicomachusClassification().classify(6))
        Assertions.assertEquals("Perfect",NicomachusClassification().classify(28))
    }

    @Test
    fun abundantNumbers(){
        Assertions.assertEquals("Abundant",NicomachusClassification().classify(12))
        Assertions.assertEquals("Abundant",NicomachusClassification().classify(24))
    }

    @Test
    fun deficientNumbers(){
        Assertions.assertEquals("Deficient",NicomachusClassification().classify(7))
        Assertions.assertEquals("Deficient",NicomachusClassification().classify(11))
    }
}