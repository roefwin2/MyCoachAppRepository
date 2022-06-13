package com.example.myshifoumi.models.symbols

import com.example.myshifoumi.models.game.Draw
import com.example.myshifoumi.models.game.Lose
import com.example.myshifoumi.models.game.Result
import com.example.myshifoumi.models.game.Win

interface Symbol

fun Symbol.resultAgainst(symbol: Symbol) : Result{
   return when{
        this == symbol -> Draw("Draw")
        this == Rock -> if (symbol == Scissor){
            Win("rock beat the scissor")
        }else{
            Lose("the paper recover the rock")
        }
        this == Scissor -> if (symbol == Rock){
            Lose("the scissor is beating by the rock")
        }else{
            Win("the scissor cut the paper")
        }
        this == Paper -> if (symbol == Scissor){
            Lose("the paper is cutted by the scissor")
        }else{
            Win("the paper cover the rock")
        }
        else -> Draw("Imcmpatible combinaison")
    }
}
