package com.example.myshifoumi.feature.gamefragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myshifoumi.models.game.PlayerVSComputerGame
import com.example.myshifoumi.models.game.Result
import com.example.myshifoumi.models.symbols.Rock
import com.example.myshifoumi.models.symbols.Symbol
import com.example.myshifoumi.navigation.ComputerGame
import com.example.myshifoumi.navigation.GameNavigation
import com.example.myshifoumi.navigation.PlayerGame
import com.example.myshifoumi.repository.ShifoumiRepository

class GameViewModel : ViewModel() {

   private val shifoumiRepository = ShifoumiRepository

    private val _gameScreen = MutableLiveData<GameScreen>().apply {
        value = GameScreen(PlayerScreen(Rock,null))
    }

    val gameScreen: LiveData<GameScreen>
        get() = _gameScreen

    fun startGameScreen(gameNavigation: GameNavigation) {
        when(gameNavigation){
            is ComputerGame -> shifoumiRepository.createComputerVSComputerGame()
            is PlayerGame -> shifoumiRepository.createPlayerVSComputerGame()
        }
    }

    fun chooseSymbol(symbol: Symbol) {
        _gameScreen.value = _gameScreen.value?.copy(gamerContainer = PlayerScreen(symbol,null))
    }

    fun play(){
        if (shifoumiRepository.game is PlayerVSComputerGame){
            (shifoumiRepository.game as PlayerVSComputerGame).playerSymbol = (_gameScreen.value?.gamerContainer as PlayerScreen).selectedSymbol
        }

     _gameScreen.value = _gameScreen.value?.copy(gamerContainer = when(val screen = _gameScreen.value?.gamerContainer){
           is ComputerScreen -> screen.copy(result = shifoumiRepository.game.startGame() )
           is PlayerScreen -> screen.copy(result = shifoumiRepository.game.startGame() )
           else -> PlayerScreen(Rock,null)
     })
    }
}

data class GameScreen(
    val gamerContainer: GamerContainer
)

sealed class GamerContainer(open val result: Result?)
data class PlayerScreen(val selectedSymbol: Symbol, override val result:Result?) : GamerContainer(result)
data class ComputerScreen(val selectedSymbol: Symbol, override val result: Result?) : GamerContainer(result)