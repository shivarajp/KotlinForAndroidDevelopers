package com.shivaraj.kotlinforandroiddevelopers.domain

public interface Command<out T>{
    fun execute(): T
}