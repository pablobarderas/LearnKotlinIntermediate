package com.example.learnkotlinintermediate

// Open indicates that you can inherit from it
// One class cannot inherit from two classes, so 'Vehicle' is a 'interface'
open class Person (name:String, age:Int) : Work(), Vehicle, Game {

    // All class have a common superClass called 'Any'
    // Open indicates that you can overwrite it
    open fun work() {
        println("This person is working")
    }

    override fun goToWork() {
        println("This person is going to work")
    }

    override fun drive() {
        println("This person drive a car")
    }

    // Game Interface

    override var game: String = "Diablo"

    override fun play() {
        println("This person is playing $game")
    }
}