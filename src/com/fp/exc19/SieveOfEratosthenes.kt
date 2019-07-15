package com.fp.exc19

fun getAllPrimes(number : Int) : Set<Int>{
    require(number >= 2){"Given number is to small"}
    var primeSet : Set<Int> = (2..number).toSet()
    for(prime in primeSet){
        var n = prime
        while(n < number){
            n += prime
            primeSet = primeSet.minus(n)
        }
    }
    return primeSet
}