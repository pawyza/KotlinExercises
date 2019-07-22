package com.fp.exc41

import java.lang.IllegalArgumentException
import java.lang.StringBuilder
import kotlin.random.Random

object Bank{

    private val accountsList = arrayListOf<Account>()

    @Throws(IllegalArgumentException::class)
    fun accessAccount(id : String, password : String) : Account{
        val account = findAccount(id)
        when (account != null && account.checkPassword(password)){
            true -> return account
            false -> throw IllegalArgumentException("Wrong id or password")
        }
    }

    private fun findAccount(id: String) : Account?{
        for(a in accountsList){ if(a.id == id) return a}
        return null
    }

    @Throws(IllegalArgumentException::class)
    fun resetAccountPassword(id : String, oldPassword : String, newPassword : String) : String{
        accessAccount(id,oldPassword).changePassword(newPassword)
        return "Password changed"
    }

    @Throws(IllegalArgumentException::class)
    fun addNewAccount(password : String, repeatedPassword : String) : String{
        if (password == repeatedPassword) {
            val newId = generateNewId()
            accountsList.add(Account(newId,password))
            return "Account $newId added"
        }
        return "Error"
    }

    @Throws(IllegalArgumentException::class)
    fun removeAccount(id : String, password : String) {accountsList.remove(accessAccount(id, password))}

    private fun generateNewId() : String{
        var newId : StringBuilder
        do {
            newId = StringBuilder()
            for (i in 1..6) 
                when(Random.nextBoolean()){
                    true -> newId.append((Random.nextInt(91 - 65) + 65).toChar())
                    false -> newId.append((Random.nextInt(10)))
                }
        } while (searchForId(newId.toString()))
        return newId.toString()
    }

    private fun searchForId(id : String) : Boolean{
        for(accounts in accountsList){
            if(accounts.id == id) return true
        }
        return false
    }
}