package com.fp.exc26

import java.lang.IllegalArgumentException

object Unpacker{

    fun unpackList(nestedList : List<Any?>) : List<Int>{
        var list = mutableListOf<Int>()
        nestedList.map { when(it){
            is Int -> list.add(it)
            is List<Any?> -> list = list.plus(unpackList(it)) as MutableList<Int>
            null -> it
            else -> throw IllegalArgumentException("Some of values are not integers or nulls")
        }}
        return list
    }
}