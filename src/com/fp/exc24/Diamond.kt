package com.fp.exc24

import kotlin.text.StringBuilder

class Diamond(var letter : String){

    private val alphabet = ('A'..'Z').toList()

    init {
        require(letter.length == 1 && Regex("""[a-zA-Z]""").containsMatchIn(letter)){"Input must be exactly one letter"}
        letter = letter.toUpperCase()
    }

    fun showDiamond() : String{
        val result = StringBuilder()
        val rowSize = alphabet.indexOf(letter.single())+1
        for(l in ('A' until letter.single())){
            result.append(generateRow(rowSize,alphabet.indexOf(l),l)).append("\n")
        }
        for(l in (letter.single().downTo('A'))){
            result.append(generateRow(rowSize,alphabet.indexOf(l),l)).append("\n")
        }
        return result.removeSuffix("\n").toString()
    }

    private fun generateRow(rowSize : Int, letterIndex : Int, letter : Char) : String{
        var row = " ".repeat(rowSize*2-1)
        row = row.replaceRange(rowSize-letterIndex-1,rowSize-letterIndex,letter.toString())
        row = row.replaceRange(rowSize+letterIndex-1,rowSize+letterIndex,letter.toString())
        return row
    }
}