package com.fp.exc33

object PrimeFactorsFinder {

    private val primes = mutableListOf<Int>(2)

    fun findAllPrimeFactors(input : Int) : List<Int>{
        require(input>1){"Input must be bigger than 2"}
        val primeFactors = mutableListOf<Int>()
        var number = input
        do{
            number = findSmallestFactor(number, primeFactors)
        }while (number != 1)
        return primeFactors
    }

    private fun findSmallestFactor(number: Int, primeFactors: MutableList<Int>): Int {
        for( p in primes){
            if(number%p == 0){primeFactors.add(p); return number/p}
        }
        do{
            val p = findNextPrime()
            if(number%p == 0){primeFactors.add(p); return number/p}
        }while(true)
    }

    private fun findNextPrime() : Int{
        var last = primes.last()
        do {
            last++
            var isPrime = true
            for(p in primes)
                if(last%p == 0) {isPrime = false; break}
            if (isPrime) {primes.add(last); return last;}
        }while(true)
    }
}