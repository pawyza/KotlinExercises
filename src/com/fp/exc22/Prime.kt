package com.fp.exc22

object Prime{

    fun getPrime(number : Int) : Int{
        require(number >= 1){"Wrong n number"}
        var n = 2
        val primeSet : MutableSet<Int> = mutableSetOf(2)
        while(primeSet.size < number){
            n++
            var isPrime = true
            for(p in primeSet){
                if(n%p == 0) {
                    isPrime = false
                    break
                }
            }
            if(isPrime == true) primeSet.add(n)
        }
        return primeSet.last()
    }
}