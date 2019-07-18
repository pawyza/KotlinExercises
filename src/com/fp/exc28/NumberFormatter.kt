package com.fp.exc28

object NumberFormatter {

    fun formatNumber(number : String) : String{
        val c = Regex("""(\D?\d\D)?""").find(number)
        require(c!!.value == "" || Regex("1").containsMatchIn(c.value)){"Wrong regional number"}
        val m= Regex("""\d{3,4}""").findAll(number).toList()
        require(m.size == 3 && m[0].value.length == 3 && m[1].value.length == 3 && m[2].value.length == 4){"Incorrect number, wrong digits grouping or too many digits"}
        require(Regex("""[2-9]\d{2}""").containsMatchIn(m[0].value) && Regex("""[2-9]\d{2}""").containsMatchIn(m[1].value)){"Incorrect number"}
        return m.map{it.value}.joinToString("")
    }
}