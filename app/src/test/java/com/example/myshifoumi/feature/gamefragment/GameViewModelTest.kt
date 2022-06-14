package com.example.myshifoumi.feature.gamefragment

import android.os.Handler
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.myshifoumi.models.symbols.Paper
import com.example.myshifoumi.models.symbols.Rock
import com.example.myshifoumi.models.symbols.Scissor
import com.example.myshifoumi.navigation.PlayerGame
import com.example.myshifoumi.repository.ShifoumiRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock

@RunWith(MockitoJUnitRunner::class)
class GameViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()


    @Test
    fun getGameScreen(){
        val vm = GameViewModel()
        val st = vm.gameScreen
        assertEquals(PlayerScreen(Rock,null),st.value?.gamerContainer)
    }

    @Test
    fun startGameScreen() {
        val vm = GameViewModel()
        val st = vm.gameScreen
        assertEquals(PlayerScreen(Rock, null), st.value?.gamerContainer)
    }

    @Test
    fun chooseSymbol() {
        val vm = GameViewModel()
        val st = vm.gameScreen
        assertEquals(PlayerScreen(Rock, null), st.value?.gamerContainer)
        vm.chooseSymbol(Scissor)
        val st2 = vm.gameScreen
        assertEquals(PlayerScreen(Scissor, null), st2.value?.gamerContainer)
        vm.chooseSymbol(Paper)
        val st3 = vm.gameScreen
        assertEquals(PlayerScreen(Paper, null), st3.value?.gamerContainer)

    }

    @Test
    fun play() {
        val vm = GameViewModel()
        vm.startGameScreen(PlayerGame)
        vm.chooseSymbol(Rock)
        vm.play()
        val st = vm.gameScreen
        assertNotEquals(null, st.value?.gamerContainer?.result)
        vm.chooseSymbol(Scissor)
        vm.play()
        val st2 = vm.gameScreen
        assertNotEquals(null, st2.value?.gamerContainer?.result)
        vm.chooseSymbol(Paper)
        vm.play()
        val st3 = vm.gameScreen
        assertNotEquals(null, st3.value?.gamerContainer?.result)

    }
}