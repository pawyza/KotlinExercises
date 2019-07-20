package com.fp.exc32

class Robot(private var name : String){
    fun resetRobot(name : String){
        this.name = name
    }

    fun getName() : String = name

    override fun toString() : String = name
}