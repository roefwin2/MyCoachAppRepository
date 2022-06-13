package com.example.myshifoumi.models.game

sealed class Result(open val msg : String)
data class Win(override val msg: String) : Result(msg)
data class Draw(override val msg: String) : Result(msg)
data class Lose(override val msg: String) : Result(msg)
