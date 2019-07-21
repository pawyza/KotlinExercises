package com.fp.exc37

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na sprawdzaniu czy w podanym tekscie wszystkie nawiasy sa domkniete oraz w prawidlowej kolejnosci
class Test{

    @Test
    fun emptyString(){
        Assertions.assertTrue(BBMatcher.checkAllBrackets(""))
    }

    @Test
    fun noBrackets(){
        Assertions.assertTrue(BBMatcher.checkAllBrackets("a"))
        Assertions.assertTrue(BBMatcher.checkAllBrackets("aaaaa"))
    }

    @Test
    fun notClosedBrackets(){
        Assertions.assertFalse(BBMatcher.checkAllBrackets(")aa"))
        Assertions.assertFalse(BBMatcher.checkAllBrackets("a("))
        Assertions.assertFalse(BBMatcher.checkAllBrackets(")a("))
        Assertions.assertFalse(BBMatcher.checkAllBrackets("aa(aa)aa{aa}aa[aaaa"))
    }

    @Test
    fun wrongOrderBrackets(){
        Assertions.assertFalse(BBMatcher.checkAllBrackets("aa(aa)aa{a[a}aaaa]aa"))
        Assertions.assertFalse(BBMatcher.checkAllBrackets("aa(aaaa{aaaa[a}a])aa"))
        Assertions.assertFalse(BBMatcher.checkAllBrackets("aa((aa){)aa{aa}aa[aa]}aa"))
        Assertions.assertFalse(BBMatcher.checkAllBrackets("aa{(aa)aa[{a}a}aa[aa]]aa"))
    }

    @Test
    fun correctBrackets(){
        Assertions.assertTrue(BBMatcher.checkAllBrackets("aa(aa)aa{aa}aa[aa]aa"))
        Assertions.assertTrue(BBMatcher.checkAllBrackets("aa(aaaa{aa}aa[aa])aa"))
        Assertions.assertTrue(BBMatcher.checkAllBrackets("aa((aa)){aa{aa}aa[aa]}aa"))
        Assertions.assertTrue(BBMatcher.checkAllBrackets("aa{(aa)aa[{aa}aa[aa]]}aa"))
    }
}