package com.example.myshifoumi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myshifoumi.models.game.Game
import com.example.myshifoumi.models.game.PlayerVSComputerGame
import com.example.myshifoumi.models.user.Computer
import com.example.myshifoumi.models.user.Gamer
import com.example.myshifoumi.models.user.Player

class MainActivity : AppCompatActivity() {
    val player = Player("Régis",1)
    val computer = Computer("CPU", 1)
    val game  = PlayerVSComputerGame(player,computer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}