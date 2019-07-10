package com.fp.exc5

fun hammingDif(dna1 : String = "",dna2 : String = "") : Int {
    var dif = 0
    when(dna1.length > dna2.length){
        true -> for (i in 0 until dna1.length){
            when (i < dna2.length) {
                true -> if(dna1[i]!=dna2[i]) dif++
                false -> dif++
            }
        }
        false -> for (i in 0 until dna2.length){
            when (i < dna1.length) {
                true -> {
                    if(dna1[i]!=dna2[i]) dif++}
                false -> {
                    dif++
                }
            }
        }
    }
    return dif
}

fun hammingDifv2(dna1 : String = "", dna2 : String = "") : Int {
    require (dna1.length == dna2.length) { "left and right strands must be of equal length." }
    //zip tworzy pary array par [(el1,el2),(el1,el2)]
    //count liczy ilosc wystapien true
    return dna1.zip(dna2).count{ it.first != it.second }
}