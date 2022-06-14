package com.example.myshifoumi.feature.choosefragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myshifoumi.R
import com.example.myshifoumi.databinding.ActivityMainBinding
import com.example.myshifoumi.databinding.ChooseGamerFragmentBinding
import com.example.myshifoumi.navigation.ComputerGame
import com.example.myshifoumi.navigation.PlayerGame

class ChooseGamerFragment : Fragment() {

    var _binding: ChooseGamerFragmentBinding? = null
    val binding: ChooseGamerFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ChooseGamerFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.player.setOnClickListener {
            val direction  = ChooseGamerFragmentDirections.actionChooseGamerFragmentToGameFragment(PlayerGame)
            findNavController().navigate(direction)
        }

        binding.computer.setOnClickListener {
            val direction  = ChooseGamerFragmentDirections.actionChooseGamerFragmentToGameFragment(ComputerGame)
            findNavController().navigate(direction)
        }
    }

}