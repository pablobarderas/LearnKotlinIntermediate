package com.example.learnkotlinintermediate

    fun main(){

        // Lesson one: Enum Classes with integer associated
        enumClasses()
    }

    // Enum Classes
    enum class Direction(val dir : Int) {

        NORTH(1), SOUTH(-1), EAST(1), WEST(-1);

        fun description(): String {

            return when (this) {
                NORTH -> "North direction"
                SOUTH -> "South direction"
                else -> "We don't know the direction"
            }
        }
    }

    private fun enumClasses(){

        // Value assignments
        // With this symbol -> ? , i indicate that the variable can be null
        var userDirection: Direction? = null
        println("Direction: $userDirection")

        userDirection = Direction.SOUTH
        println("Direction: $userDirection")

        // Defect properties
        println("Propety name: ${userDirection.name}")

        // Valor position
        println("Propety ordinal: ${userDirection.ordinal}")

        // Functions
        println(userDirection.description())

        // Initialization
        println("$userDirection pos: ${userDirection.dir}")
    }