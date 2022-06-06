package com.example.learnkotlinintermediate

// Open indicates that you can inherit from it
open class Person (name:String, age:Int){

    // All class have a common superClass called 'Any'
    // Open indicates that you can overwrite it
    open fun work() {
        println("Esta persona está trabajando")
    }
}