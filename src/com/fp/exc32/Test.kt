package com.fp.exc32

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

//Zadanie polegajace na stworzeniu fabryki robotow o unikalnych losowo generowanych nazwach
class Test{

    @Test
    fun factoryAddRobot(){
        Assertions.assertEquals(Robot("AA000").toString(),RobotsFactory.createRobot("AA000").toString())
    }

    @Test
    fun panelTest(){
        val robotsPanel = RobotsPanel()
        robotsPanel.createRobot()
        robotsPanel.createRobot()
        robotsPanel.createRobot()

        //RobotsAdded
        Assertions.assertTrue(Regex("""Robot nr.0 [A-Z]{2}\d{3}\nRobot nr.1 [A-Z]{2}\d{3}\nRobot nr.2 [A-Z]{2}\d{3}""").matches(robotsPanel.displayRobots())){"Robots added successfully"}


        val robotOne = robotsPanel.getRobot(0)
        //RobotSearch
        Assertions.assertTrue(robotsPanel.searchForName(robotOne))

        //RobotReset
        robotsPanel.resetRobot(0)
        Assertions.assertNotEquals(robotOne,robotsPanel.getRobot(0)){"Robot reset successful"}
    }
}