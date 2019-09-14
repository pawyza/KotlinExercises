package com.fp.exc48

import kotlin.math.ceil

object BinarySearch {

    fun <T : Comparable<T>> search(list : List<T>, value : T ) : Int  = try {
            binarySearch(list.sorted(),value,ceil((list.size/2).toDouble()).toInt())
        } catch (e : NullPointerException){
            -1
        }

    private fun <T : Comparable<T>> binarySearch(list : List<T>, value : T,index : Int) : Int {
        require(list.isNotEmpty()){throw KotlinNullPointerException()}
        return when{
            list[index] == value -> index
            list[index] < value -> index + 1 + binarySearch(list.drop(index+1),value, ceil((list.drop(index+1).size/2).toDouble()).toInt())
            list[index] > value -> binarySearch(list.take(index),value, ceil((list.take(index).size/2).toDouble()).toInt())
            else -> throw NullPointerException()
    }
}}