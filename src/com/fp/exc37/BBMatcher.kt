package com.fp.exc37

object BBMatcher{

    fun checkAllBrackets(fullText : String) : Boolean{
        val brackets = fullText.replace(Regex("[^(){}\\[\\]]"),"")
        val toClose = arrayListOf<Char>()
        val openingSigns = arrayListOf('(','{','[')
        for (i in brackets){
            when(openingSigns.contains(i)) {
                true -> toClose.add(i)
                false -> when(toClose.isEmpty()){
                    true -> return false
                    false -> when (toClose.last()) {
                        '(' -> if (i == ')') toClose.removeAt(toClose.lastIndex) else return false
                        '{' -> if (i == '}') toClose.removeAt(toClose.lastIndex) else return false
                        '[' -> if (i == ']') toClose.removeAt(toClose.lastIndex) else return false
                        else -> return false
                    }
                }
            }
        }
        return toClose.isEmpty()
    }
}