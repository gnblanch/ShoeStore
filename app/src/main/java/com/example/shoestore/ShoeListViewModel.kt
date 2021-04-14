package com.example.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeListViewModel : ViewModel() {


    // Setup the Live Data arrays to hold the shoe informaiton
/*
    private lateinit var _shoe : MutableLiveData<String>
    val shoe: LiveData<String>
        get() = _shoe


 */


    private val shoeDetailsArrayList: ArrayList <String>



    init {

        shoeDetailsArrayList = java.util.ArrayList()
        shoeDetailsArrayList.add(0,"BasketBallStar")
        shoeDetailsArrayList.add(1,"Nike")
        shoeDetailsArrayList.add(2, "12.5")
        shoeDetailsArrayList.add(3,"Basketball Shoe")
        shoeDetailsArrayList.add(4,"TrackStar")
        shoeDetailsArrayList.add(5,"Reebok")
        shoeDetailsArrayList.add(6, "9.5")
        shoeDetailsArrayList.add(7,"Track Shoe")
        shoeDetailsArrayList.add(8,"NightOnTheTown")
        shoeDetailsArrayList.add(9,"Prada")
        shoeDetailsArrayList.add(10, "5")
        shoeDetailsArrayList.add(11,"High Heal Formal")


        Timber.i("Element 8 is ${shoeDetailsArrayList.get(8)}")
        Timber.i("Element 9 is ${shoeDetailsArrayList.get(9)}")
        Timber.i("Element 10 is ${shoeDetailsArrayList.get(10)}")
        Timber.i("Element 11 is ${shoeDetailsArrayList.get(11)}")

    }

/*
    val index = shoeDetailsArrayList.size-1
    shoeDetailsArrayList.add(index, name)
    shoeDetailsArrayList.add(index+1, company)
    shoeDetailsArrayList.add(index+2, size)
    shoeDetailsArrayList.add(index+3, description)

    Timber.i("Element $index is ${shoeDetailsArrayList.get(index)}")
    Timber.i("Element ${index+1} is ${shoeDetailsArrayList.get(index+1)}")
    Timber.i("Element ${index+2} is ${shoeDetailsArrayList.get(index+2)}")
    Timber.i("Element ${index+3} is ${shoeDetailsArrayList.get(index+3)}")



 */

}