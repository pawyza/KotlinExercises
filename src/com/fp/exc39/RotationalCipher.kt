package com.fp.exc39

import java.awt.font.NumericShaper

class RotationalCipher(private val rotation : Int){

    private val key = createKey()

    private fun createKey() :  Array<Array<Char>> = arrayOf(Array<Char>(26) { i -> (i+97).toChar()},
            Array<Char>(26) {i -> (((i+ when(rotation<0){
                true -> (rotation%26) + 26
                false -> rotation
            })%26)+97).toChar()})

    fun codeText(text : String) : String{
        require(!Regex("""\d""").containsMatchIn(text)){"Message cannot contain any digits"}
        return text.replace(" ","").map { key[1].get(it.toLowerCase().toInt()-97) }.joinToString("")
    }

    fun decodeText(text : String) : String{
        require(!Regex("""\d""").containsMatchIn(text)){"Message cannot contain any digits"}
        return text.replace(" ","").map { key[0].get(key[1].indexOf(it.toLowerCase()))}.joinToString("")
    }
}