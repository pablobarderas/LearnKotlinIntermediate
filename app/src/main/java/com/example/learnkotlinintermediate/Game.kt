package com.example.learnkotlinintermediate

// The interfaces cannot save status
interface Game {

    var game: String

    fun play()

    fun stream() {
        println("I'm streaming $game")
    }
}