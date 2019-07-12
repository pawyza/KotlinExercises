package com.fp.exc15

class LuhnAlgorithm(number : String){

    var result = false

    init{
        require(number.length > 1){"Number must be longer than 1"}
        require(!Regex("""\D""").containsMatchIn(number.replace(" ",""))){"There are other signs than numbers in given number"}
        if(number.replace(" ","").mapIndexedNotNull{
            index, c ->
            var num = c.toString().toInt()
            when(index%2){
            0 -> {
                num *= 2
                when (num > 9) {
                    true -> num - 9
                    false -> num
                }
            }
            else -> num
        }}.sum()%10 == 0) result = true
    }

}