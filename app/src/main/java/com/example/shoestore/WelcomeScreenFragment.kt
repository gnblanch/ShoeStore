package com.example.shoestore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.InstructionsScreenFragmentBinding
import com.example.shoestore.databinding.WelcomeScreenFragmentBinding

class WelcomeScreenFragment : Fragment() {

    private lateinit var viewModel: WelcomeScreenViewModel
    private lateinit var binding: WelcomeScreenFragmentBinding


    companion object {
        fun newInstance() = WelcomeScreenFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.welcome_screen_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(WelcomeScreenViewModel::class.java)

        binding.welcomeScreenViewModel = viewModel
        binding.setLifecycleOwner (this)

        binding.buttonNavigateToInstructionsScreen.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeScreenFragment_to_instructionsScreenFragment) }


        /* Sets up event listening to navigate the player when the game is finished

        viewModel.eventGameFinish.observe(viewLifecycleOwner, Observer { isFinished ->
            if (isFinished) {
                val currentScore = viewModel.score.value ?: 0
                val action = GameFragmentDirections.actionGameToScore(currentScore)
                findNavController(this).navigate(action)
                viewModel.onGameFinishComplete()
            }
        })
         */

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WelcomeScreenViewModel::class.java)
        // TODO: Use the ViewModel
    }

}