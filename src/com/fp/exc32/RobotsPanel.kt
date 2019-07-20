package com.fp.exc32

import java.lang.StringBuilder
import kotlin.random.Random

class RobotsPanel(){

    private var robotsRecord = mutableListOf<Robot>()

    fun createRobot(){
        robotsRecord.add(RobotsFactory.createRobot(generateName()))
    }

    fun resetRobot(robotNr : Int){
        robotsRecord[robotNr].resetRobot(generateName())
    }

    fun displayRobots() : String{
        return robotsRecord.mapIndexed{ i, r -> "Robot nr." + i + " " + r.getName()}.joinToString("\n")
    }

    fun getRobot(robotNr : Int) : String{
        val robot = robotsRecord[robotNr]
        return robot.getName()
    }

    private fun generateName() : String {
        var newName : StringBuilder
        do {
            newName = StringBuilder()
            for (i in 1..2) newName.append((Random.nextInt(91 - 65) + 65).toChar())
            for (i in 1..3) newName.append((Random.nextInt(10)))
        } while (searchForName(newName.toString()))
        return newName.toString()
    }

    fun searchForName(name : String) : Boolean{
        for(robot in robotsRecord){
            if(robot.getName() == name) return true
        }
        return false
    }
}