package com.example.learnkotlinintermediate

    fun main(){

        // Lesson one: Enum Classes with integer associated
        //enumClasses()

        // Lesson two: Nested and Inner Classes
        //nestedAndInnerClasses()

        // Lesson three: Inheritance
        //classIneritance()

        // Lesson four: Interfaces
        //interfaces()

        // Lesson five: Visibility Modifiers
        //visibilityModifiers()

        // Lesson six: Data classes
        dataClasses()

    }

    // Lesson one
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

    // Lesson two
    private fun nestedAndInnerClasses(){

        // Nested Class
        val myNestedClass = MyNestedAndInnerClass.MyNestedClass()
        val sum = myNestedClass.sum(2,4)
        println("Resultado: $sum")

        // Inner Class
        val myInnerClass = MyNestedAndInnerClass().myInnerClass()
        val sumTwo = myInnerClass.sumTwo(5)
        println("Resultado de sumar dos: $sumTwo")
    }

    // Lesson three
    private fun classIneritance(){

        // Instance of Programmer and Designer
        val programmer = Programmer("Pablo", 21, "Kotlin")
        programmer.work()
        programmer.sayLanguage()
        programmer.goToWork()
        programmer.drive()

        println("---------------------------")
        val designer = Designer("Viky", 16)
        designer.work()
        designer.goToWork()
    }

    // Lesson four
    private fun interfaces(){

        val gamer = Person("Gamer", 23)
        gamer.play()
        gamer.stream()
        gamer.game = "Pac-Man"
        println("******* Changing game ... *******")
        gamer.play()
    }

    // Lesson five
    private fun visibilityModifiers() {
        val visibility = Visibility()
        visibility.name = "Pablo"
        //visibility.sayMyName()
    }

    // Lesson six
    private fun dataClasses(){

        val vicky = Worker("Vicky", 16, "Pharmaceutic")
        vicky.lastWork = "School"

        // Without nothing inside
        val iker = Worker()
        val pablo = Worker()

        // equals && hasCode
        if (vicky.equals(iker)) println("They are equal") else println("They are not the same")
        if (pablo == iker) println("They are equal") else println("They are not the same")

        // toString
        println(vicky.toString())

        // copy
        val hugo = iker.copy(age = 18)
        println("Hugo dates: ${hugo.toString()}")

        // componentN (Take the first two properties)
        val (name, age) = vicky
        println(name)
        println(age)
    }