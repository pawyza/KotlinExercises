package com.fp.exc41

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AccountTest{

    @Test
    fun wrongId(){
        var exception = Assertions.assertThrows(IllegalArgumentException::class.java){Account("AG41S","aaaaaaa")}
        Assertions.assertEquals("Wrong id",exception.message)
        exception = Assertions.assertThrows(IllegalArgumentException::class.java){Account("AG41SAA","aaaaaaa")}
        Assertions.assertEquals("Wrong id",exception.message)
    }

    @Test
    fun wrongPassword(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){Account("AG41SA","aaaaa")}
        Assertions.assertEquals("Password is too short",exception.message)
    }

    @Test
    fun changeBalance(){
        val account = Account("AAG41S","aaaaaa")
        Assertions.assertEquals("0,00",account.getAccountBalance())
        Assertions.assertTrue(account.changeBalance(20.0))
        Assertions.assertEquals("20,00",account.getAccountBalance())
        Assertions.assertTrue(account.changeBalance(0.011))
        Assertions.assertEquals("20,01",account.getAccountBalance())
        Assertions.assertTrue(account.changeBalance(-20.01))
        Assertions.assertEquals("0,00",account.getAccountBalance())
        Assertions.assertFalse(account.changeBalance(-20.01))
        Assertions.assertEquals("0,00",account.getAccountBalance())

    }

    @Test
    fun changePassword(){
        val account = Account("AAG41S","aaaaaa")
        Assertions.assertTrue(account.changePassword("bbbbbb"))
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){account.changePassword("ccccc")}
        Assertions.assertEquals("Password is too short",exception.message)
    }

    @Test
    fun checkPassword(){
        Assertions.assertTrue(Account("AAG41S","aaaaaa").checkPassword("aaaaaa"))
        Assertions.assertFalse(Account("AAG41S","aaaaaa").checkPassword("bbbbbbb"))
    }
}