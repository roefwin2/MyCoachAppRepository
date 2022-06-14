package com.example.myshifoumi.repository

import com.example.myshifoumi.models.game.ComputerVSComputerGame
import com.example.myshifoumi.models.game.PlayerVSComputerGame
import com.example.myshifoumi.models.user.Computer
import com.example.myshifoumi.models.user.Player
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ShifoumiRepositoryTest {


    @Test
    fun createPlayerVSComputerGame() {
        val repo  = ShifoumiRepository
        repo.createPlayerVSComputerGame()
        val st  = repo.game
        assertEquals(PlayerVSComputerGame(gamer1= Player(name="Régis", score=1), gamer2= Computer(name="CPU1", score=1)),st)
    }

    @Test
    fun createComputerVSComputerGame() {
        val repo  = ShifoumiRepository
        repo.createComputerVSComputerGame()
        val st  = repo.game
        assertEquals(ComputerVSComputerGame(gamer1= Computer("CPU1", 1), gamer2= Computer(name="CPU2", score=1)),st)
    }
}