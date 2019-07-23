package com.fp.exc44

class ETL(oldScoreSystem : Map<Int,List<String>>) {

    private val newScoreSystem: MutableMap<String, Int> = mutableMapOf()

    init {
        oldScoreSystem.map { score -> score.value.map { it.toLowerCase() to score.key }.toMap() }
            .map { newScoreSystem.putAll(it) }
    }

    fun showScoreSystem(): String = newScoreSystem.map { "${it.key} for ${it.value} points" }.joinToString("\n")
}