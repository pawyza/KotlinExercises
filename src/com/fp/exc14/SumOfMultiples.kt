package com.fp.exc14

class SumOfMultiples(multiples : Set<Int>, number : Int) {
    var multiplesSet : Set<Int> = setOf()

    init{
        require(multiples.filter { it > number }.isEmpty()){"One or more multiples are bigger than number"}
        multiples.map{multiplesSet = multiplesSet.plus(getMultiplesSet(it,number))}
        }


    private fun getMultiplesSet(multiple : Int, number : Int) : Set<Int>{
        val multiplesSet : MutableSet<Int> = mutableSetOf(multiple)
        while((multiplesSet.max()!! + multiple) < number){
            multiplesSet.add(multiplesSet.max()!! + multiple)
        }
        return multiplesSet
    }

    fun getMultiplesSum() : Int = multiplesSet.sum()
}