package com.example.myshifoumi.models.game

sealed class Result(open val msg : String)
data class Win(override val msg: String) : Result(msg){
    override fun toString(): String {
        return "Win" + " " + this.msg
    }
}
data class Draw(override val msg: String) : Result(msg){
    override fun toString(): String {
        return "Draw" + " " + this.msg
    }
}
data class Lose(override val msg: String) : Result(msg){
    override fun toString(): String {
        return "Lose" + " " + this.msg
    }
}
