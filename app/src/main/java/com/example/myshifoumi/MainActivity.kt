package com.example.myshifoumi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myshifoumi.databinding.ActivityMainBinding
import com.example.myshifoumi.models.game.Game
import com.example.myshifoumi.models.game.PlayerVSComputerGame
import com.example.myshifoumi.models.symbols.Paper
import com.example.myshifoumi.models.symbols.Rock
import com.example.myshifoumi.models.symbols.Scissor
import com.example.myshifoumi.models.user.Computer
import com.example.myshifoumi.models.user.Gamer
import com.example.myshifoumi.models.user.Player

class MainActivity : AppCompatActivity() {
    var _binding: ActivityMainBinding? = null
    val binding: ActivityMainBinding
        get() = _binding!!

    val player = Player("Régis", 1)
    val computer = Computer("CPU", 1)
    val game = PlayerVSComputerGame(player, computer)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.scissor.setOnClickListener {
            game.playerSymbol = Scissor
        }
        binding.rock.setOnClickListener {
            game.playerSymbol = Rock
        }
        binding.paper.setOnClickListener {
            game.playerSymbol = Paper
        }

        binding.button.setOnClickListener {
           val result = game.startGame()
            binding.result.text = result.msg
        }
    }
}