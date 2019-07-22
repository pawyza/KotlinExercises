package com.fp.exc40

object ISBN13 : ISBN {
    override fun checkIfValid(number: String): Boolean {
        val plainISBN = number.replace("-", "")
        require(plainISBN.length == 13 && Regex("""\d{13}""").containsMatchIn(plainISBN)) { "Not proper ISBN13 number" }
        return 10 - plainISBN.mapIndexed { i, n ->
            if(i < 12) when (i%2 == 0) {
                    true -> n.toString().toInt()
                    false -> 3 *  n.toString().toInt()
                } else 0
        }.sum() % 10 == plainISBN[12].toString().toInt()
    }
}