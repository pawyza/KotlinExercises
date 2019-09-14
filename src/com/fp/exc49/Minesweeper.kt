package com.fp.exc49

import java.lang.IllegalArgumentException
import kotlin.random.Random

class Minesweeper{

    private var mineMap : Array<Array<String>> = emptyArray()
    private var fullMap : Array<Array<String>> = emptyArray()


    constructor(size : Int){
        initArray(size)
        for(i in 1..size)
            addMine()
        fullMap = mineMap
        generateNumbers()
    }

    constructor(size : Int, minesPos : Array<Pair<Int,Int>>){
        initArray(size)
        for(mine in minesPos){
            require(mine.first < size && mine.second < size){"Wrong mine coordinates!"}
            try {
                addMine(mine.first, mine.second)
            } catch (e : IllegalArgumentException){
                println(e.message)
            }
        }
        fullMap = mineMap
        generateNumbers()
    }

    private fun initArray(size : Int){
        require(size > 0){"Size must be positive number!"}
        mineMap = Array(size){Array(size){" "}}
    }

    private fun addMine(){
        val x = Random.nextInt(mineMap.size)
        val y = Random.nextInt(mineMap.size)
        when (mineMap[x][y]){
            " " -> mineMap[x][y] = "*"
            "*" -> addMine()
        }
    }

    private fun addMine(x : Int, y : Int){
        when (mineMap[x][y]){
            " " -> mineMap[x][y] = "*"
            "*" -> throw IllegalArgumentException("Mine already placed on x:$x y:$y!")
        }
    }

    private fun generateNumbers(){
        mineMap.mapIndexed{ rowIdx, row -> row.mapIndexed{ colIdx, value -> if(value == "*") fullMap.countMine(rowIdx,colIdx) } }
    }

    private fun Array<Array<String>>.countMine(xCor : Int, yCor : Int){
       for(x in (xCor-1)..(xCor+1))
           for(y in (yCor-1)..(yCor+1)) {
               if (x >= 0 && y >= 0 && x < this.size && y < this.size) {
                   this[x][y] = when (this[x][y]) {
                       " " -> "1"
                       "*" -> "*"
                       else -> (this[x][y].toInt() + 1).toString()
                   }
               }
           }
    }

    fun showMineMap(){
        println("+${"-".repeat(mineMap.size)}+")
        println(mineMap.map { row -> "|${row.joinToString(""){it}}|"}.joinToString("\n"))
        println("+${"-".repeat(mineMap.size)}+")
    }

    fun showFullMap(){
        println("+${"-".repeat(fullMap.size)}+")
        println(fullMap.map { row -> "|${row.joinToString(""){it}}|"}.joinToString("\n"))
        println("+${"-".repeat(fullMap.size)}+")
    }
}