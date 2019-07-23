package com.fp.exc43

import java.lang.StringBuilder

object BeerSong{

    private fun bottleNumberToString(num : Int) = when(num){ 0 ->  "no more bottles"; 1 -> "1 bottle"; else -> "$num bottles"}

    fun getSong() : String{
        val song = StringBuilder()
        val max = 99
        for (beers in max downTo 0){
            when(beers){
                0 -> song.append(bottleNumberToString(beers).replaceRange(0,1,"N") + " of beer on the wall, ${bottleNumberToString(beers)} of beer.\n" +
                    "Go to the store and buy some more, ${bottleNumberToString(max)} of beer on the wall.")
                else ->  song.appendln("${bottleNumberToString(beers)} of beer on the wall, ${bottleNumberToString(beers)} of beer.\n" +
                        "Take ${if(beers != 1) "one" else "it"} down and pass it around, ${bottleNumberToString(beers-1)} of beer on the wall.\n")
            }
        }
        return song.toString()
    }
}