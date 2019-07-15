package com.fp.exc21

object AtbashCipher {

    private val codingKey = ('a'..'z').zip('z'.downTo('a')).toMap()
    private val decodingKey = ('z'.downTo('a')).zip('a'..'z').toMap()

    fun code(message : String) : String{
        val changedMessage = message.replace(" ","").toLowerCase()
        require(!Regex("""\d""").containsMatchIn(changedMessage)){"Message cannot contain any digits"}
        return changedMessage.map { c -> codingKey[c] }.joinToString("")
    }

    fun decode(message : String) : String {
        val changedMessage = message.replace(" ","").toLowerCase()
        require(!Regex("""\d""").containsMatchIn(changedMessage)){"Message cannot contain any digits"}
        return changedMessage.map { c -> decodingKey[c]}.joinToString("")
    }
}