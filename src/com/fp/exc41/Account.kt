package com.fp.exc41

import java.math.BigDecimal

class Account(val id : String, private var password : String){

    private var balance = BigDecimal.ZERO

    init {
        require(id.length == 6){"Wrong id"}
        require(password.length>=6){"Password is too short"}
    }

    fun changeBalance(amount : Double) : Boolean{
        return when (balance.plus(BigDecimal(amount)).compareTo(BigDecimal.ZERO) > -1 ){
            true -> {balance = balance.plus(BigDecimal(amount)); true;}
            false -> false
        }
    }

    fun getAccountBalance() : String = String.format("%.2f",balance.toDouble())

    fun changePassword(password : String) : Boolean{
        require(password.length>=6){"Password is too short"}
        this.password = password
        return true
    }

    fun checkPassword(password: String) : Boolean = this.password == password
}