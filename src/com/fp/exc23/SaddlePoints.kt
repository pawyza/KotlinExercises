package com.fp.exc23

import java.lang.StringBuilder

object SaddlePoints {
    var matrix = arrayOf(intArrayOf(0))
        set(value) {
            require(value.isNotEmpty()){"Array cannot be empty"}
            for (a in value.iterator()){
                require(a.isNotEmpty()){"Array cannot be empty"}
                require(a.size == value[0].size){"Rows must be equal length"}
            }
            require(value.size < 1000){"Input matrix is to big"}
            require(value[0].size < 1000){"Input matrix is to big"}
            field = value
        }

    fun displaySaddlePoints() : String =
        findSaddlePoints().joinToString("\n") { sp -> String.format("x: %d y: %d e: %d", sp[0], sp[1], sp[2]) }

    private fun findSaddlePoints() : List<IntArray>{
        val result = mutableListOf<IntArray>()

        for ((y,row) in matrix.iterator().withIndex()) {
            val max = row.max()!!
            row.mapIndexed { x, e -> when (e == max){
                true -> {
                    var eColMin = matrix[0][x]
                    for(rowCol in matrix.iterator()) {
                        if(rowCol[x] <= eColMin) eColMin = rowCol[x]
                    }
                    if (e == eColMin ) result.add(intArrayOf(x, y, e))
                    else false
                }
                else -> false
            }}
        }
        return result
    }

    fun displayMatrix() : String {
        val result = StringBuilder(matrixSquare(" ")).append(matrixSquare(" "))
        for (x in (0 until  matrix[0].size)) {
            result.append(matrixSquare(x.toString()))
        }
        result.append("\n").append(matrixSquare(" ")).append(matrixSquare("|"))
        for (x in (0 until  matrix[0].size)) {
            result.append("-----")
        }
        for ((i,y) in matrix.iterator().withIndex()) {
            result.append("\n").append(matrixSquare((i).toString())).append(matrixSquare("|"))
            for (x in y.iterator()) {
                result.append(matrixSquare(x.toString()))
            }
        }
        return result.toString()
    }

    private fun matrixSquare(value : String) : String = when(value.length) {
        1 -> String.format("   %s ", value)
        2 -> String.format("  %s ", value)
        3 -> String.format(" %s ", value)
        else -> String.format("  %s  ", value)
    }
}