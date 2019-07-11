package com.fp.exc12

class Handshake(private val decimal : Int) {

    private var handshake: Array<String>

    init {
        require(decimal < 32) { "Cannot generate proper secret handshake" }
        handshake = generateHandshake()
    }

    private fun generateHandshake(): Array<String> {
        val resultList : MutableList<String> = mutableListOf()
        decimal.toString(2).reversed().mapIndexed{
            index, c -> if(c == '1')
            when(index){
            0 ->  resultList.add("wink")
            1 ->  resultList.add("double blink")
            2 ->  resultList.add("close your eyes")
            3 ->  resultList.add("jump")
            4 ->  resultList.reverse()
            }
        }
        return resultList.toTypedArray()
    }

    fun printHandshake(): String {
        var result = ""
        handshake.forEachIndexed { index, string ->
            result = when (index == 0) {
                true -> result.plus(string)
                false -> result.plus(",").plus(string)
            }
        }
        return result
    }
}