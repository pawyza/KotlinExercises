package com.fp.exc35
object Bob{

    private enum class SentenceType{
        QUESTION,YELLING,YELLEDQUESTION,BOB,ELSE
    }

    fun respondTo(sentence : String) : String{
        return when(sentenceType(sentence)){
            SentenceType.QUESTION -> "Sure."
            SentenceType.YELLING -> "Whoa, chill out!"
            SentenceType.YELLEDQUESTION -> "Calm down, I know what I'm doing!"
            SentenceType.BOB -> "Fine. Be that way!"
            SentenceType.ELSE -> "Whatever."
        }
    }

    private fun sentenceType(sentence: String) : SentenceType{
        return if(Regex("""bob[?!.]{0,2}""").matches(sentence.toLowerCase())) SentenceType.BOB
        else if(Regex("\\?!").containsMatchIn(sentence) || Regex("!\\?").containsMatchIn(sentence)) SentenceType.YELLEDQUESTION
        else if(Regex("!").containsMatchIn(sentence)) SentenceType.YELLING
        else if(Regex("\\?").containsMatchIn(sentence)) SentenceType.QUESTION
        else Bob.SentenceType.ELSE
}
}