package com.fp.exc8

fun getAcronym(sentence : String = "") : String
{
    require( sentence != "" ){"Cannot generate acronym without proper sentence"}
    return sentence.split(" ","-").map{it[0].toUpperCase()}.joinToString(separator = "")
}