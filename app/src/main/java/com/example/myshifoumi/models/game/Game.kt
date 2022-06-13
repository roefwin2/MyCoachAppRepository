package com.example.myshifoumi.models.game

import com.example.myshifoumi.models.symbols.Rock
import com.example.myshifoumi.models.symbols.Symbol
import com.example.myshifoumi.models.symbols.resultAgainst
import com.example.myshifoumi.models.user.Gamer

interface Game{
    fun startGame() : Result
}

data class PlayerVSComputerGame(val gamer1 : Gamer,val gamer2: Gamer) : Game {
    var playerSymbol : Symbol = Rock
        get() = this.playerSymbol
        set(value) {
        field = value
    }

    override fun startGame(): Result {
       return gamer1.playOneSymbol(playerSymbol).resultAgainst(gamer2.playOneSymbol(playerSymbol))
    }
}

