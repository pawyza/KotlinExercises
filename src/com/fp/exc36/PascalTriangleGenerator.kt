package com.fp.exc36

object PascalTriangleGenerator{

    fun showTriangleOfRows(rows : Int) : String{
        require(rows >= 0){"Rows number can't be negative"}
        return generateTriangleOfRows(rows).mapIndexed{ i, r -> " ".repeat(rows - (i+1)) + r.map {it}.joinToString(" ") }.joinToString("\n")

    }

    private fun generateTriangleOfRows(rows : Int) : List<List<Int>>{
        val result = arrayListOf<ArrayList<Int>>()
        for(rowLen in 0 until rows){
            if(result.isEmpty()) result.add(arrayListOf(1))
            else result.add(generateNextRow(result.last()))
        }
        return result
    }

    private fun generateNextRow(oldRow : ArrayList<Int>) : ArrayList<Int>{
        val result = arrayListOf<Int>()
        for(i in 0..oldRow.size){
            result.add(when(i){
                0 -> oldRow[0]
                oldRow.size ->  oldRow[oldRow.size-1]
                else -> oldRow[i-1] + oldRow[i]
            })
        }
        return result
    }
}