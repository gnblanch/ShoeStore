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
import androidx.navigation.ui.navigateUp
import com.example.shoestore.databinding.ShoeDetailFragmentBinding
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeDetailFragment()
    }

    //private val model: SharedViewModel by activityViewModels()
    private lateinit var viewModel: ShoeDetailViewModel
    private lateinit var binding: ShoeDetailFragmentBinding

    var name = "empty"
    var size = "0"
    var company = "empty"
    var description = "empty"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                         savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.shoe_detail_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)

        binding.shoeDetailViewModel = viewModel

        binding.setLifecycleOwner(this)



        viewModel.newName.observe(viewLifecycleOwner, Observer { newShoeName ->
        Timber.i("newShoeName $newShoeName loaded into ShoeDetailFragment")
            name = newShoeName
        })

        viewModel.newCompany.observe(viewLifecycleOwner, Observer { newShoeCompany ->
            Timber.i("newShoeCompany $newShoeCompany loaded into ShoeDetailFragment")
            company = newShoeCompany
        })

        viewModel.newSize.observe(viewLifecycleOwner, Observer { newShoeSize ->
            Timber.i("newShoeSize $newShoeSize loaded into ShoeDetailFragment")
            size = newShoeSize
        })

        viewModel.newDescription.observe(viewLifecycleOwner, Observer { newShoeDescription ->
            Timber.i("newShoeDescription $newShoeDescription loaded into ShoeDetailFragment")
            description = newShoeDescription
        })



        binding.buttonSave.setOnClickListener {view: View ->
            view.findNavController().navigate(ShoeDetailFragmentDirections.
            actionShoeDetailFragmentToShoeListFragment(name, company, size, description))
        }

        binding.buttonCancel.setOnClickListener {view: View ->
            viewModel.saveNewShoe()
            view.findNavController().navigate(ShoeDetailFragmentDirections.
            actionShoeDetailFragmentToShoeListFragment(name, company, size, description))
        }


        return binding.root


    }

}