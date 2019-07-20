package com.fp.exc34

import java.lang.StringBuilder

object AllergyTester{

    private val allergies = arrayOf("eggs","peanuts","shellfish","strawberries","tomatos","chocolate","pollen","cats")

    fun displayAllergies(score : Int) : String{
        require(score >= 0){"Score cannot be negative"}
        val result = StringBuilder()
        val patientAllergies = determineAllergies(score)
        when(patientAllergies.isEmpty()){
            true -> result.append("Patient don't have any allergies")
            false -> {
                result.append("Patient is allergic to some of tested allergens.\nThose allergens are:\n")
                result.append(patientAllergies.map {it}.joinToString("\n"))
            }
        }
        return result.toString()
    }

    private fun determineAllergies(score : Int) : List<String>{
        val patientAllergies = mutableListOf<String>()

        val realScore = score%256
        for((i,b) in Integer.toBinaryString(realScore).reversed().withIndex()){
            if(b == '1') patientAllergies.add(allergies[i])
        }
        return patientAllergies
    }
}