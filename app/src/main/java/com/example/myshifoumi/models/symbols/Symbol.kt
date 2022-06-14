package com.example.myshifoumi.models.symbols

import com.example.myshifoumi.models.game.Draw
import com.example.myshifoumi.models.game.Lose
import com.example.myshifoumi.models.game.Result
import com.example.myshifoumi.models.game.Win

interface Symbol

fun Symbol.resultAgainst(symbol: Symbol) : Result{
   return when{
        this == symbol -> Draw("${this.toString()} vs ${symbol.toString()} => Draw")
        this == Rock -> if (symbol == Scissor){
            Win(" ${this.toString()} vs ${symbol.toString()} => rock beat the scissor")
        }else{
            Lose(" ${this.toString()} vs ${symbol.toString()} => the paper recover the rock")
        }
        this == Scissor -> if (symbol == Rock){
            Lose(" ${this.toString()} vs ${symbol.toString()} => the scissor is beating by the rock")
        }else{
            Win(" ${this.toString()} vs ${symbol.toString()} => the scissor cut the paper")
        }
        this == Paper -> if (symbol == Scissor){
            Lose(" ${this.toString()} vs ${symbol.toString()} => the paper is cutted by the scissor")
        }else{
            Win("${this.toString()} vs ${symbol.toString()} => the paper cover the rock")
        }
        else -> Draw("Imcompatible combinaison")
    }
}
