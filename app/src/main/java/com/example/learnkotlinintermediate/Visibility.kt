package com.example.learnkotlinintermediate

class Visibility {

    var name: String? = null

    private fun sayMyName(){
        // If name have a valor, print it, if else: print 'dont have name'
        name?.let {
            println("My name is $it")
        } ?: run {
            println("I do not have a name")
        }
    }

}

open class VisibilityTwo {

    protected fun sayMyNameTwo() {
        val visibility = Visibility()
        visibility.name = "Vicky"

    }
}

class VisibilityThree : VisibilityTwo() {

    internal val age: Int? = null

    fun sayMyNameThree() {
        sayMyNameTwo()
    }

}