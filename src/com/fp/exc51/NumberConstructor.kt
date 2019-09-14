package com.fp.exc51

import java.lang.IllegalArgumentException
import java.lang.StringBuilder


object NumberConstructor {

    private val numberMap = mapOf<Int, String>(
        0 to "",
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine",
        10 to "ten",
        11 to "eleven",
        12 to "twelve",
        13 to "thirteen",
        14 to "fourteen",
        15 to "fifteen",
        16 to "sixteen",
        17 to "seventeen",
        18 to "eighteen",
        19 to "nineteen",
        20 to "twenty",
        30 to "thirty",
        40 to "forty",
        50 to "fifty",
        60 to "sixty",
        70 to "seventy",
        80 to "eighty",
        90 to "ninety"
    )

    fun say(number: Int): String = when (number == 0) {
        true -> "zero";
        false -> {
            val numberParts = splitNumber(number)
            val resultToSay = StringBuilder()
            for (i in numberParts.indices) {
                resultToSay.insert(0, generateNumberText(numberParts[i]))
            }
            resultToSay.toString().trim()
        }
    }

    private fun splitNumber(number: Int): ArrayList<Pair<Int, String>> {
        val result = ArrayList<Pair<Int, String>>()
        val matchResults = Regex(".{1,3}").findAll(number.toString().reversed())
        for ((i, r) in matchResults.withIndex()) {
            result.add(
                Pair(
                    Integer.valueOf(r.value.reversed()),
                    when (r.value.toInt() == 0) {
                        true -> ""
                        false -> when (i) {
                            0 -> ""
                            1 -> " thousand "
                            2 -> " million "
                            3 -> " billion "
                            else -> throw IllegalArgumentException()
                        }
                    }
                )
            )
        }
        return result
    }

    private fun generateNumberText(numberPart: Pair<Int, String>): String {
        val result = when (numberPart.first < 20) {
            true -> numberMap[numberPart.first]
            false -> when (numberPart.first < 100) {
                true -> numberMap[numberPart.first / 10 * 10] + "-" + numberMap[numberPart.first % 10]
                false -> numberMap[numberPart.first / 100] + when(numberPart.first%100 == 0) { true -> " hundred"; false -> " hundred "} + numberMap[numberPart.first % 100 / 10 * 10] + when (numberPart.first % 10 != 0) {
                    true -> "-"; false -> ""
                } + numberMap[numberPart.first % 10]
            }
        }
        return "$result${numberPart.second}"
    }
}