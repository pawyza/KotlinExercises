package com.fp.exc30

import java.lang.StringBuilder

object WordCounter {

    fun displayAllSentencesWords(text : String) : String{
        require(text.replace(" ", "").isNotEmpty()){"Text cannot be empty"}
        val result = StringBuilder()
        sentenceWordCounter(text).map { i -> result.appendln(i.value.first)
            i.value.second.map { w -> result.appendln(w.key + ": " +w.value)
            }}
        result.replace(result.length-2,result.length,"")
        return result.toString()
    }

    private fun sentenceWordCounter (text : String) : Map<Int,Pair<String,Map<String,Int>>>{
        val splitedSentences = mutableMapOf<Int,Pair<String,Map<String,Int>>>()
        sentenceSplicer(text).mapIndexed{i, s ->
            val wordsMap = mutableMapOf<String,Int>()
            s.replace(Regex("""[^\d\w\s]"""),"").split(" ").map{ w -> wordsMap.putIfAbsent(w,0); wordsMap.computeIfPresent(w) { _ : String, v : Int -> v + 1} }
            splitedSentences.put(i,Pair(s,wordsMap as Map<String,Int>))}
        return splitedSentences
    }

    private fun sentenceSplicer(text : String) : List<String> {
        return when (Regex("""[.?!]{1,3}""").containsMatchIn(text)) {
            true -> {
                val result = text.split("[.?!]{1,3}".toRegex()).dropLast(1)  as MutableList<String>
                if(result.size > 1) result.mapIndexed { i, s -> result[i] = s.trim()}
                result
            }
            false -> listOf(text)

        }
    }
}