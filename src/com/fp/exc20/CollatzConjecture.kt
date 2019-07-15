package com.fp.exc20

class CollatzConjecture{

    fun calculateSteps(number : Int) : MutableList<Int>{
        require(number >= 1){"Number must be positive"}
        return when(number == 1){
            true -> mutableListOf(1)
            false -> when(number%2){
                0 -> calculateSteps(number/2).plus(number).toMutableList()
                else -> calculateSteps(3*number+1).plus(number).toMutableList()
            }
        }
    }
}