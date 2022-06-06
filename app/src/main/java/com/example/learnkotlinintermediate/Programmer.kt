package com.example.learnkotlinintermediate

class Programmer(name:String, age:Int, val language: String): Person(name, age)  {

    override fun work() {
        println("This person is programming on $language")
    }

    fun sayLanguage() {
        println("This programmer use $language")
    }

    override fun goToWork() {
        println("This person is going to Google")
    }
}