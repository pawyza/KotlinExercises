package com.fp.exc35

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na wybraniu odpowiedzi w postaci lancucha znakow na podstawie zdania zawierajacego znaki interpunkcyjne
class Test{

    @Test
    fun noSentence(){
        Assertions.assertEquals("Whatever.",Bob.respondTo(""))
    }

    @Test
    fun question(){
        Assertions.assertEquals("Sure.",Bob.respondTo("Question question?"))
        Assertions.assertEquals("Sure.",Bob.respondTo("Another question?"))
    }

    @Test
    fun yell(){
        Assertions.assertEquals("Whoa, chill out!",Bob.respondTo("Yelling!"))
        Assertions.assertEquals("Whoa, chill out!",Bob.respondTo("Yelling yelling!"))
    }

    @Test
    fun yellQuestion(){
        Assertions.assertEquals("Calm down, I know what I'm doing!",Bob.respondTo("Question question!?"))
        Assertions.assertEquals("Calm down, I know what I'm doing!",Bob.respondTo("Another question?!"))
    }

    @Test
    fun bob(){
        Assertions.assertEquals("Fine. Be that way!",Bob.respondTo("Bob"))
        Assertions.assertEquals("Fine. Be that way!",Bob.respondTo("Bob!"))
        Assertions.assertEquals("Fine. Be that way!",Bob.respondTo("Bob?"))
        Assertions.assertEquals("Fine. Be that way!",Bob.respondTo("Bob?!"))
        Assertions.assertEquals("Fine. Be that way!",Bob.respondTo("Bob!?"))
    }

    @Test
    fun somethingElse(){
        Assertions.assertEquals("Whatever.",Bob.respondTo("Trash trash"))
        Assertions.assertEquals("Whatever.",Bob.respondTo("Trash trash bob."))
        Assertions.assertEquals("Whatever.",Bob.respondTo("Trash trash bob"))
    }
}