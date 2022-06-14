package com.example.myshifoumi.models.game

import com.example.myshifoumi.models.symbols.Rock
import com.example.myshifoumi.models.symbols.Symbol
import com.example.myshifoumi.models.symbols.resultAgainst
import com.example.myshifoumi.models.user.Computer
import com.example.myshifoumi.models.user.Gamer
import com.example.myshifoumi.models.user.Player

interface Game{
    fun startGame() : Result
}

data class PlayerVSComputerGame(val gamer1 : Player,val gamer2: Computer) : Game {
    var playerSymbol : Symbol = Rock
        get() {
            return field
        }
        set(value) {
        field = value
    }

    override fun startGame(): Result {
       return gamer1.playOneSymbol(playerSymbol).resultAgainst(gamer2.playOneSymbol(playerSymbol))
    }
}

data class ComputerVSComputerGame(val gamer1 : Computer,val gamer2: Computer) : Game {

    override fun startGame(): Result {
        return gamer1.playOneSymbol(null).resultAgainst(gamer2.playOneSymbol(null))
    }
}

