package com.fp.exc7

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

//Zadnie polega na podaniu liczby sekund, a następnie na podstawie tego wyznaczenie wieku
//dla podanych sekund dla wybranej planety
class Test {

    @Test
    fun noSecondsNoPlanetGiven() {
        assertEquals(0.0, AgeChecker().getAgeOnPlanet())
    }

    @Test
    fun noPlanetGiven() {
        assertEquals(0.0, AgeChecker(100_000).getAgeOnPlanet())
    }

    @Test
    fun noSecondsGiven() {
        assertEquals(0.0, AgeChecker().getAgeOnPlanet(EarthAge()))
    }

    @Test
    fun oneEarthYearToMercuryYears() {
        assertEquals(0.2408467, AgeChecker(31_557_600).getAgeOnPlanet(MercuryAge()))
    }

    @Test
    fun oneEarthYearToVenusYears() {
        assertEquals(0.61519726, AgeChecker(31_557_600).getAgeOnPlanet(VenusAge()))
    }

    @Test
    fun oneEarthYearToEarthYears() {
        assertEquals(1.0, AgeChecker(31_557_600).getAgeOnPlanet(EarthAge()))
    }

    @Test
    fun oneEarthYearToMarsYears() {
        assertEquals(1.8808158, AgeChecker(31_557_600).getAgeOnPlanet(MarsAge()))
    }

    @Test
    fun oneEarthYearToJupiterYears() {
        assertEquals(11.862615, AgeChecker(31_557_600).getAgeOnPlanet(JupiterAge()))
    }

    @Test
    fun oneEarthYearToSaturnYears() {
        assertEquals(29.447498, AgeChecker(31_557_600).getAgeOnPlanet(SaturnAge()))
    }

    @Test
    fun oneEarthYearToUranusYears() {
        assertEquals(84.016846, AgeChecker(31_557_600).getAgeOnPlanet(UranusAge()))
    }

    @Test
    fun oneEarthYearToNeptunYears() {
        assertEquals(164.79132, AgeChecker(31_557_600).getAgeOnPlanet(NeptunAge()))
    }
}