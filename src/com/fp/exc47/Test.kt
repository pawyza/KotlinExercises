package com.fp.exc47

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

//Zadanie polegajace na napisaniu programu okreslajacego polozenie i zwrot robota po wykonaniu podanych instrukcji
class Test{

    @Test
    fun emptyPath(){
        Assertions.assertEquals("Position X: 0 Y: 0 Direction: NORTH",RobotMovement(Pair(0,0),Direction.NORTH).givePath(""))
    }

    @Test
    fun wrongPath(){
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java){Assertions.assertEquals("",RobotMovement(Pair(0,0),Direction.NORTH).givePath("la"))}
        Assertions.assertEquals("Wrong path format",exception.message)
    }

    @Test
    fun correctPath(){
        Assertions.assertEquals("Position X: -1 Y: 0 Direction: WEST",RobotMovement(Pair(0,0),Direction.NORTH).givePath("LA"))
        Assertions.assertEquals("Position X: 0 Y: -1 Direction: SOUTH",RobotMovement(Pair(0,0),Direction.NORTH).givePath("LLA"))
        Assertions.assertEquals("Position X: 1 Y: 0 Direction: EAST",RobotMovement(Pair(0,0),Direction.NORTH).givePath("LLLA"))
        Assertions.assertEquals("Position X: 0 Y: 1 Direction: NORTH",RobotMovement(Pair(0,0),Direction.NORTH).givePath("LLLLA"))
        Assertions.assertEquals("Position X: 1 Y: 0 Direction: EAST",RobotMovement(Pair(0,0),Direction.NORTH).givePath("RA"))
        Assertions.assertEquals("Position X: 0 Y: -1 Direction: SOUTH",RobotMovement(Pair(0,0),Direction.NORTH).givePath("RRA"))
        Assertions.assertEquals("Position X: -1 Y: 0 Direction: WEST",RobotMovement(Pair(0,0),Direction.NORTH).givePath("RRRA"))
        Assertions.assertEquals("Position X: 0 Y: 1 Direction: NORTH",RobotMovement(Pair(0,0),Direction.NORTH).givePath("RRRRA"))
        Assertions.assertEquals("Position X: 0 Y: 0 Direction: NORTH",RobotMovement(Pair(0,0),Direction.NORTH).givePath("LALARRARAL"))
    }
}