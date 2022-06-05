package com.example.learnkotlinintermediate

class MyNestedAndInnerClass {

    private val one = 1

    private fun returnOne (): Int {
        return one
    }

    // Nested Class (Can't access to external variables or functions)
    class MyNestedClass {

        fun sum(num1:Int, num2:Int):Int {
            return num1 + num2
        }
    }

    // Inner Class (Can access to external variables or functions)
    inner class myInnerClass {

        fun sumTwo(first:Int) : Int {
            return first + returnOne() + one
        }
    }
}