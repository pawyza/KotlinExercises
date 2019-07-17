package com.fp.exc25

object Isogram{

    fun isIsogram(word : String) : Boolean{
        require(!Regex(" ").containsMatchIn(word)){"Cannot contain spaces"}
        require(!Regex("""\d""").containsMatchIn(word)){"Cannot contain numbers"}
        val letters : MutableMap<Char,Int> = mutableMapOf()
        word.toLowerCase().replace(Regex("""\W"""),"").map { c ->when(letters.containsKey(c)){
            true -> return false
            false -> letters.put(c,1)
        } }
        return true
    }
}