package com.fp.exc31

import java.lang.IllegalArgumentException
import javax.swing.plaf.basic.BasicSplitPaneUI

object SpiralGenerator {

    fun displaySpiral(size: Int): String{
        require(size >= 0){"Size must be positive number"}
        return createSpiral(size).map { row -> row.map{it}.joinToString(" ")}.joinToString("\n")
    }


    private fun createSpiral(size : Int) : Array<Array<Int?>> {
        val result: Array<Array<Int?>> = Array(size) {arrayOfNulls<Int?>(size)}
        var index = Pair(-1, 0)
        var value = 1

        for (i in size downTo 1){
            index = index move Direction.RIGHT
            result[index.second][index.first] = value++
        }
        for (step in size-1 downTo 1){
            when ((size-step)%2 == 1){
                true -> {
                    for (m in step downTo 1) {
                        index = index move Direction.DOWN
                        result[index.second][index.first] = value++
                    }
                    for (m in step downTo 1) {
                        index = index move Direction.LEFT
                        result[index.second][index.first] = value++
                    }
                }
                false -> {
                    for (m in step downTo 1) {
                        index = index move Direction.UP
                        result[index.second][index.first] = value++
                    }
                    for (m in step downTo 1) {
                        index = index move Direction.RIGHT
                        result[index.second][index.first] = value++
                    }
                }
            }
        }
        return result
    }

    private infix fun Pair<Int,Int>.move(dir : Direction) : Pair<Int,Int> {
        return when(dir){
            Direction.LEFT -> Pair(first.minus(1),second)
            Direction.RIGHT -> Pair(first.plus(1),second)
            Direction.UP -> Pair(first,second.minus(1))
            Direction.DOWN -> Pair(first,second.plus(1))
        }
    }
}



enum class Direction {
    LEFT, RIGHT, UP, DOWN
}