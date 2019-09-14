package com.fp.exc47

class RobotMovement(var position : Pair<Int,Int>,var direction : Direction){

    fun givePath(path : String) : String{
        require(!path.contains(Regex("""[^RLA]"""))){"Wrong path format"}
        path.map { c-> when(c){
            'A' -> advance()
            'L' -> turnLeft()
            'R' -> turnRight()
        }}
        return "Position X: ${position.first} Y: ${position.second} Direction: ${direction.name}"
    }

    private fun turnLeft(){
        direction = when(direction){
            Direction.NORTH -> Direction.WEST
            Direction.WEST-> Direction.SOUTH
            Direction.SOUTH -> Direction.EAST
            Direction.EAST -> Direction.NORTH
        }
    }

    private fun turnRight(){
        direction = when(direction){
            Direction.NORTH -> Direction.EAST
            Direction.EAST-> Direction.SOUTH
            Direction.SOUTH -> Direction.WEST
            Direction.WEST-> Direction.NORTH
        }
    }

    private fun advance(){
        position = when(direction){
            Direction.NORTH -> Pair(position.first,position.second+1)
            Direction.EAST-> Pair(position.first+1,position.second)
            Direction.SOUTH-> Pair(position.first,position.second-1)
            Direction.WEST-> Pair(position.first-1,position.second)
        }
    }
}

enum class Direction{
    NORTH,EAST,WEST,SOUTH
}