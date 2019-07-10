package com.fp.exc4

import java.util.regex.Matcher
import java.util.regex.Pattern

fun checkIfPangram(sentence : String = "") : Boolean{
    val pat : Pattern = Pattern.compile("[a-zA-Z]")
    val mat : Matcher = pat.matcher(sentence)
    val res : MutableSet<String> = mutableSetOf()

    while (mat.find()){
        res.add(mat.group().toLowerCase())
    }

    for(i in 'a'..'z'){
        if(!res.contains(i.toString())){
            return false
        }
    }

    return true
}