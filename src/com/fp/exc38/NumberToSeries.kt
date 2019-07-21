package com.fp.exc38

class NumberToSeries(private val number : Int){

    init {
        require(number>=0){"Number cannot be negative"}
    }

    fun displaySeriesOf(len : Int) : String = getSeriesOf(len).map{it}.joinToString(" ")

    fun getSeriesOf(len : Int) : List<Int>{
        require(len>0){"Series cannot be negative or zero"}
        val numberString = number.toString()
        val result = numberString.windowed(len).map {it.toInt()}.toList()
        return result
    }
}