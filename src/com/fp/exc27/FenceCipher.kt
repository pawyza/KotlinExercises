package com.fp.exc27

import java.lang.StringBuilder

class FenceCipherEncoder(private val rails : Int){

    fun encode(text : String) : String{
        val railList = mutableListOf<StringBuilder>()
        for(i in 0 until rails) railList.add(StringBuilder())
        var currentRail = 0
        text.replace(" ","").mapIndexed{i, c ->
            when(i%((rails*2)-2) < rails-1){
                true ->{
                    railList[currentRail].append(c)
                    currentRail++
                }
                false -> {
                    railList[currentRail].append(c)
                    currentRail--
                }
            }

        }
        return railList.map {it.toString() }.joinToString("")
    }

    fun decode(code : String) : String{
        val railList = mutableListOf<StringBuilder>()
        for(i in 0 until rails) railList.add(StringBuilder())
        var currentRail = 0
        code.mapIndexed{i, c ->
            when(i%((rails*2)-2) < rails-1){
                true ->{
                    railList[currentRail].append(".")
                    currentRail++
                }
                false -> {
                    railList[currentRail].append(".")
                    currentRail--
                }
            }
        }
        var cutableCode = code
        for(r in 0 until rails){
            val rLen = railList[r].length
            railList[r] = StringBuilder(cutableCode.substring(0,rLen))
            cutableCode =  cutableCode.substring(rLen,cutableCode.length)
        }

        var originalText = StringBuilder()
        currentRail = 0
        for (c in 0 until code.length){
            when(c%((rails*2)-2) < rails-1){
                true ->{
                    originalText = originalText.append(railList[currentRail][0])
                    railList[currentRail].delete(0,1)
                    currentRail++
                }
                false -> {
                    originalText = originalText.append(railList[currentRail][0])
                    railList[currentRail].delete(0,1)
                    currentRail--
                }
            }
        }

       return originalText.toString()
    }
}