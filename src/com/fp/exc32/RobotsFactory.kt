package com.fp.exc32


class RobotsFactory {
    companion object {
        fun createRobot(randomName : String) : Robot = Robot(randomName)
    }
}