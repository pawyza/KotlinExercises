package com.fp.exc40

object ISBN10 : ISBN {
    override fun checkIfValid(number: String): Boolean {
        val plainISBN = number.replace("-", "")
        require(plainISBN.length == 10 && Regex("""\d{9}[0-9X]""").containsMatchIn(plainISBN)) { "Not proper ISBN10 number" }
        return plainISBN.mapIndexed { i, n ->
            when (n == 'X') {
                true -> 10
                else -> n.toString().toInt() * (10 - i)
            }
        }.sum() % 11 == 0
    }
}