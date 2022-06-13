package com.example.myshifoumi.models.user

import com.example.myshifoumi.models.symbols.Paper
import com.example.myshifoumi.models.symbols.Rock
import com.example.myshifoumi.models.symbols.Scissor
import com.example.myshifoumi.models.symbols.Symbol

interface Gamer{
    fun playOneSymbol(chooseSymbol: Symbol): Symbol
}
data class Player(val name : String, val score :Int): Gamer{

    override fun playOneSymbol(chooseSymbol: Symbol): Symbol {
        return chooseSymbol
    }
}
data class Computer(val name : String,val score: Int) : Gamer{

    override fun playOneSymbol(chooseSymbol: Symbol): Symbol {
        val list = listOf(Rock, Paper, Scissor)
        return list.random()
    }
}
