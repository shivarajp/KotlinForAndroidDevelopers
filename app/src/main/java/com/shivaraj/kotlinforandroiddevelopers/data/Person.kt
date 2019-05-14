package com.shivaraj.kotlinforandroiddevelopers.data

open class Animal(name: String)

class Person(private var name: String, surname:String) : Animal(name){
    init {
        name = "Shiv"
    }

    fun printName() : String{
        return "ss$name"
    }
}