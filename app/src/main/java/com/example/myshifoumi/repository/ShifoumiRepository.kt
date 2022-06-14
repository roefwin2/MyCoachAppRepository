package com.example.myshifoumi.repository

import com.example.myshifoumi.models.game.ComputerVSComputerGame
import com.example.myshifoumi.models.game.Game
import com.example.myshifoumi.models.game.PlayerVSComputerGame
import com.example.myshifoumi.models.user.Computer
import com.example.myshifoumi.models.user.Player

object ShifoumiRepository {

    private val player = Player("Régis", 1)
    private val computer1 = Computer("CPU1", 1)
    private val computer2 = Computer("CPU2", 1)
    lateinit var game: Game

    fun createPlayerVSComputerGame(){
       game = PlayerVSComputerGame(player, computer1)
    }

    fun createComputerVSComputerGame(){
        game = ComputerVSComputerGame(computer1, computer2)
    }





}