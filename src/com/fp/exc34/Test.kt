package com.fp.exc34

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

/*Zadanie polegajace na stworzeniu listy alergenow na podstawie wyniku w postaci liczby calkowitej oraz dostarczonej
listy alergenow wraz z ich wartoscia
eggs (1)
peanuts (2)
shellfish (4)
strawberries (8)
tomatoes (16)
chocolate (32)
pollen (64)
cats (128)
 */
class Test {

    @Test
    fun negativeScore(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){AllergyTester.displayAllergies(-1)}
        Assertions.assertEquals("Score cannot be negative",exception.message)
    }

    @Test
    fun patientWithoutAllergies(){
        Assertions.assertEquals("Patient don't have any allergies",AllergyTester.displayAllergies(0))
    }

    @Test
    fun determineAllergies(){
        Assertions.assertEquals("Patient is allergic to some of tested allergens.\nThose allergens are:\neggs",AllergyTester.displayAllergies(1))
        Assertions.assertEquals("Patient is allergic to some of tested allergens.\nThose allergens are:\neggs\npeanuts",AllergyTester.displayAllergies(3))
        Assertions.assertEquals("Patient is allergic to some of tested allergens.\nThose allergens are:\neggs\npeanuts\nshellfish",AllergyTester.displayAllergies(7))
        Assertions.assertEquals("Patient is allergic to some of tested allergens.\nThose allergens are:\npeanuts\nchocolate",AllergyTester.displayAllergies(34))
        Assertions.assertEquals("Patient is allergic to some of tested allergens.\nThose allergens are:\neggs",AllergyTester.displayAllergies(257))
        Assertions.assertEquals("Patient is allergic to some of tested allergens.\nThose allergens are:\npeanuts",AllergyTester.displayAllergies(258))
        Assertions.assertEquals("Patient is allergic to some of tested allergens.\nThose allergens are:\neggs",AllergyTester.displayAllergies(513))
        Assertions.assertEquals("Patient is allergic to some of tested allergens.\nThose allergens are:\npeanuts",AllergyTester.displayAllergies(514))
    }
}