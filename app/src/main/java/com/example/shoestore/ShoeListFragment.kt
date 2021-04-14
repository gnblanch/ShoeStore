package com.example.shoestore

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.databinding.ShoeListFragmentBinding

class ShoeListFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeListFragment()
    }

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: ShoeListFragmentBinding



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.shoe_list_fragment,
                container,
                false
        )

        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)

        binding.shoeListScreenViewModel = viewModel
        binding.setLifecycleOwner (this)

        var args = ShoeDetailFragmentArgs.fromBundle(requireArguments())
// Toast shows the arguments are available using their declared names
        Toast.makeText(context,
                "NameEntered: ${args.name}, CompanyEntered: ${args.company}, SizeEntered: ${args.size }, " +
                        "DescriptionEntered: ${args.description}", Toast.LENGTH_LONG).show()

        binding.fabToDetails.setOnClickListener { view: View ->
            view.findNavController().navigate(ShoeDetailFragmentDirections.
            actionShoeDetailFragmentToShoeListFragment(name, company, size, description)
            )
            }

        setHasOptionsMenu(true)

        return binding.root


    }

    // Inflate the menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    // Navigate to the menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

}