package com.example.mvvmcoffee.data.dto

class UserDto(
    private val id: Int,
    private val name: String
) {
    val getId: Int
        get() = id

    val getName: String
        get() = name
}