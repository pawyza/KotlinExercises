package com.fp.exc41

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BankTest {

    @Test
    fun addAccount(){
        Assertions.assertTrue(Regex("""Account [A-Z0-9]{6} added""").containsMatchIn(Bank.addNewAccount("aaaaaa","aaaaaa")))
        Assertions.assertTrue(Regex("""Account [A-Z0-9]{6} added""").containsMatchIn(Bank.addNewAccount("bbbbbb","bbbbbb")))
        Assertions.assertTrue(Regex("""Account [A-Z0-9]{6} added""").containsMatchIn(Bank.addNewAccount("cccccc","cccccc")))
        Assertions.assertEquals("Error",Bank.addNewAccount("aaaaaa","aaaaa"))
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){Bank.addNewAccount("aaaaa","aaaaa")}
        Assertions.assertEquals("Password is too short",exception.message)
    }

    @Test
    fun resetAccountPassword(){
        val id = Regex("""[A-Z0-9]{6}""").find(Bank.addNewAccount("aaaaaa","aaaaaa"))!!.value
        Assertions.assertEquals("Password changed",Bank.resetAccountPassword(id,"aaaaaa","bbbbbbb"))
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){Bank.addNewAccount("aaaaa","aaaaa")}
        Assertions.assertEquals("Password is too short",exception.message)
    }

    @Test
    fun removeAccount(){
        val id = Regex("""[A-Z0-9]{6}""").find(Bank.addNewAccount("aaaaaa","aaaaaa"))!!.value
        var exception = Assertions.assertThrows(IllegalArgumentException::class.java){Bank.removeAccount(id,"aaaaa")}
        Assertions.assertEquals("Wrong id or password",exception.message)
        Bank.removeAccount(id,"aaaaaa")
        exception = Assertions.assertThrows(IllegalArgumentException::class.java){Bank.accessAccount(id,"aaaaaa")}
        Assertions.assertEquals("Wrong id or password",exception.message)
    }

    @Test
    fun accessAccountBalance(){
        val id = Regex("""[A-Z0-9]{6}""").find(Bank.addNewAccount("aaaaaa","aaaaaa"))!!.value
        Assertions.assertEquals("0,00",Bank.accessAccount(id,"aaaaaa").getAccountBalance())
        Assertions.assertTrue(Bank.accessAccount(id,"aaaaaa").changeBalance(20.0))
        Assertions.assertEquals("20,00",Bank.accessAccount(id,"aaaaaa").getAccountBalance())
    }
}