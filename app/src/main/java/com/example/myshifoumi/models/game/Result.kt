package com.example.myshifoumi.models.game

sealed class Result
data class Win(val score : Int)
data class Draw(val score : Int)
data class Lose(val score : Int)
