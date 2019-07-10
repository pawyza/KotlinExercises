package com.fp.exc6

import java.time.LocalDate
import java.time.LocalDateTime

fun addSeconds(seconds : Long) : LocalDate = LocalDateTime.now().plusSeconds(seconds).toLocalDate()

fun main(args : Array<String>){
    println(addSeconds(1_000_000_000))
}