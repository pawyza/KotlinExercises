package com.fp.exc17

class LargestSeries(var inputString : String){

    init{
        require(Regex("""\D""").containsMatchIn(inputString)){"Input contains other signs than digits"}
    }

    fun getLargesrSeriesOf(numberOfDigits : Int) : Int{
        require(numberOfDigits > 0){"Series is to short"}
        require(inputString.length >= numberOfDigits){"Series is too long"}
        var max = 0
        for(s in 0..inputString.length-numberOfDigits)
            if(inputString.substring(s,numberOfDigits).toInt() > max) max = inputString.substring(s,numberOfDigits).toInt()
        return max
    }
}