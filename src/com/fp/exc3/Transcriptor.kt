package com.fp.exc3

fun transcript(dna : String = "") : String = dna.map{
    when(it){
        'A' -> 'U'
        'T'  -> 'A'
        'C' -> 'G'
        'G' -> 'C'
        else -> it
    }
}.joinToString("")
