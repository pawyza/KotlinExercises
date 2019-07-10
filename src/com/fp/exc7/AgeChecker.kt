package com.fp.exc7

class AgeChecker(val ageInSeconds : Long = 0){
    fun getAgeOnPlanet(planetAge : Age = EarthAge()) : Double = planetAge.getAge((ageInSeconds/EARTH_YEAR_IN_SECONDS).toDouble())

    companion object {
        const val EARTH_YEAR_IN_SECONDS : Long = 31_557_600
    }
}

//Wzorzec strategii

interface Age{
    fun getAge(ageOnEarth : Double) : Double
}

class MercuryAge() : Age{
    override fun getAge(ageOnEarth: Double): Double = ageOnEarth * 0.2408467
}

class VenusAge() : Age{
    override fun getAge(ageOnEarth: Double): Double = ageOnEarth * 0.61519726
}

class EarthAge() : Age{
    override fun getAge(ageOnEarth: Double): Double = ageOnEarth
}

class MarsAge() : Age{
    override fun getAge(ageOnEarth: Double): Double = ageOnEarth * 1.8808158
}

class JupiterAge() : Age{
    override fun getAge(ageOnEarth: Double): Double = ageOnEarth * 11.862615
}

class SaturnAge() : Age{
    override fun getAge(ageOnEarth: Double): Double = ageOnEarth * 29.447498
}

class UranusAge() : Age{
    override fun getAge(ageOnEarth: Double): Double = ageOnEarth * 84.016846
}

class NeptunAge() : Age{
    override fun getAge(ageOnEarth: Double): Double = ageOnEarth * 164.79132
}