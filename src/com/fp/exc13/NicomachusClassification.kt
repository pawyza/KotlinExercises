package com.fp.exc13

class NicomachusClassification {
    fun classify(number: Int): String {
        require(number >= 0){"Number must be positive"}
        val sum = getFactorsSum(number)
        return when{
            sum < number -> "Deficient"
            sum == number -> "Perfect"
            sum > number -> "Abundant"
            else -> ""
        }
    }

    private fun getFactorsSum(number : Int) : Int = (1..(number/2)).filter{number % it == 0}.sum()


}