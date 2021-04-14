package com.example.shoestore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.shoestore.databinding.WelcomeScreenFragmentBinding
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.InstructionsScreenFragmentBinding


class InstructionsScreenFragment : Fragment() {

    private lateinit var viewModel: InstructionsScreenViewModel
    private lateinit var binding: InstructionsScreenFragmentBinding

    companion object {
        fun newInstance() = InstructionsScreenFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                        savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.instructions_screen_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(InstructionsScreenViewModel::class.java)

        binding.instructionsScreenViewModel = viewModel
        binding.setLifecycleOwner (this)


        binding.buttonGotoShoeList.setOnClickListener {view: View ->
            view.findNavController().navigate(InstructionsScreenFragmentDirections.actionInstructionsScreenFragmentToShoeListFragment())
            //findNavController().navigate(R.id.action_instructionsScreenFragment_to_shoeListFragment)
        }

        return binding.root

    }
}