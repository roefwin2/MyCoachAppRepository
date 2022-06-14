package com.example.myshifoumi.feature.gamefragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.myshifoumi.R
import com.example.myshifoumi.databinding.ActivityMainBinding
import com.example.myshifoumi.databinding.GameFragmentBinding
import com.example.myshifoumi.models.symbols.Paper
import com.example.myshifoumi.models.symbols.Rock
import com.example.myshifoumi.models.symbols.Scissor
import com.example.myshifoumi.navigation.ComputerGame
import com.example.myshifoumi.navigation.PlayerGame

class GameFragment : Fragment() {

    var _binding: GameFragmentBinding? = null
    val binding: GameFragmentBinding
        get() = _binding!!

    private lateinit var viewModel: GameViewModel

    private val args : GameFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = GameFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        viewModel.gameScreen.observe(viewLifecycleOwner, Observer {
            processGameScreen(it)
        })

        viewModel.startGameScreen(args.gameType)
        when(args.gameType){
            PlayerGame ->{
                binding.scissor.setOnClickListener {
                    viewModel.chooseSymbol(Scissor)
                }
                binding.rock.setOnClickListener {
                    viewModel.chooseSymbol(Rock)
                }
                binding.paper.setOnClickListener {
                    viewModel.chooseSymbol(Paper)
                }
            }
            ComputerGame ->{
                binding.scissor.isVisible = false
                binding.rock.isVisible = false
                binding.paper.isVisible = false

            }
        }

        binding.button.setOnClickListener {
            viewModel.play()
        }
    }

    private fun processGameScreen(it: GameScreen?) {
        binding.result.text = (it?.gamerContainer?.result ?: "No game started").toString()
        when(val player = it?.gamerContainer){
            is PlayerScreen -> {
                when(player.selectedSymbol){
                    Rock -> {
                        binding.rock.isSelected = true
                        binding.scissor.isSelected = false
                        binding.paper.isSelected = false
                    }
                    Scissor -> {
                        binding.rock.isSelected = false
                        binding.scissor.isSelected = true
                        binding.paper.isSelected = false
                    }
                    Paper -> {
                        binding.rock.isSelected = false
                        binding.scissor.isSelected = false
                        binding.paper.isSelected = true
                    }
                }
            }
            else ->{}
        }
    }

}