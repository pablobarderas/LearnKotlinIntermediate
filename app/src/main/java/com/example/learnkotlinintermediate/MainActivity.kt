package com.example.learnkotlinintermediate

import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

typealias MyMapList = MutableMap<Int, ArrayList<String>>
typealias Myfun = (Int, String, MyMapList) -> Boolean
typealias MyNestedClass = MyNestedAndInnerClass.MyNestedClass

fun main() {

    // Lesson one: Enum Classes with integer associated
    //enumClasses()

    // Lesson two: Nested and Inner Classes
    //nestedAndInnerClasses()

    // Lesson three: Inheritance
    //classInheritance()

    // Lesson four: Interfaces
    //interfaces()

    // Lesson five: Visibility Modifiers
    //visibilityModifiers()

    // Lesson six: Data classes
    //dataClasses()

    // Lesson seven: Type Aliases
    //typeAliases()

    // Lesson eight: Destructuring
    //destructuring()

    // Lesson nine: Extensions
    //extensions()

    // Lesson ten: Lambdas
    lambdas()
}

// Lesson one
enum class Direction(val dir: Int) {

    NORTH(1), SOUTH(-1), EAST(1), WEST(-1);

    fun description(): String {

        return when (this) {
            NORTH -> "North direction"
            SOUTH -> "South direction"
            else -> "We don't know the direction"
        }
    }
}

private fun enumClasses() {

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
private fun nestedAndInnerClasses() {

    // Nested Class
    val myNestedClass = MyNestedClass()
    val sum = myNestedClass.sum(2, 4)
    println("Resultado: $sum")

    // Inner Class
    val myInnerClass = MyNestedAndInnerClass().myInnerClass()
    val sumTwo = myInnerClass.sumTwo(5)
    println("Resultado de sumar dos: $sumTwo")
}

// Lesson three
private fun classInheritance() {

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
private fun interfaces() {

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
private fun dataClasses() {

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

// Lesson seven

// All aliases defined at the beginning

private var myMap: MyMapList = mutableMapOf()

private fun typeAliases() {

    var myNewMap: MyMapList = mutableMapOf()
    myNewMap[1] = arrayListOf("Pablo", "Barderas")
    myNewMap[2] = arrayListOf("Vicky", "Fernández")

    myMap = myNewMap

}

// Lesson eight
private fun destructuring() {

    // With '_' we skip the second valor
    val pablo = Worker("Pablo", 21, "Programmer")
    val (name, _, work) = pablo
    println("$name, $work")

    // With DataClasses attributes can be accessed through 'componentX'
    val vicky = Worker("Vicky", 16, "Pharmaceutic")
    println(vicky.component1())

    val (nameV, ageV, workV) = myWorker()

    // ComponentN, destructuring on Maps
    val myMap = mapOf(1 to "Pablo", 2 to "Barderas")
    for ((id, valor) in myMap) {
        println("$id, $valor")
    }

}

private fun myWorker(): Worker {
    return Worker("Vicky", 16, "Pharmaceutic")
}

// Lesson nine
private fun extensions() {

    val myDate = Date()
    println(myDate.customFormat())
    println(myDate.formatSize)

    var myDateNullable: Date? = null
    println(myDateNullable.customFormat())
    println(myDateNullable.formatSize)
}

// Lesson ten
private fun lambdas() {

    val myIntList = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // .filter check a condition and return it if is true
    val myFilterIntList = myIntList.filter { myInt ->

        println(myInt)
        // Because I also want to add it
        if (myInt == 1) {
            return@filter true
        }

        myInt > 5 // return this condition
    }
    println(myFilterIntList)

    val myFunSum = fun(first: Int, second: Int): Int = first + second
    val myMultFun = fun(first: Int, second: Int): Int = first * second

    println(myOperateFun(4, 5, myFunSum))
    println(myOperateFun(4, 5, myMultFun))
    println(myOperateFun(4, 4) { first, second -> first - second })

    myAsyncFun("Pablo") { name ->
        println(name)

    }
}

private fun myOperateFun(first: Int, second: Int, myFun: (Int, Int) -> Int): Int {
    return myFun(first, second)
}

// Unit == void
private fun myAsyncFun(name: String, hello: (String) -> Unit) {
    val myNewString = "Hello $name!"
    hello(myNewString)

    thread {
        Thread.sleep(5000)
        hello(myNewString)
    }

    thread {
        Thread.sleep(1000)
        hello(myNewString)
    }

    thread {
        Thread.sleep(7000)
        hello(myNewString)
    }
}