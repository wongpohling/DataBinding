package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //lateint = late initialise(assign value first, initialise later)
    private lateinit var binding: ActivityMainBinding
    private val myName:MyName = MyName("WPL")
    private  val myContactNo:MyContactNo = MyContactNo("012-3456789")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.buttonSetName.setOnClickListener{
            //it = object(button)
            addNickName(it)
            addContactNo(it)
        }
        binding.myName = myName
        binding.myContactNo = myContactNo
    }

    private fun addContactNo(it: View?) {
        binding.apply {
            myContactNo?.contactNo = editTextContactNo.text.toString()
            this.invalidateAll()
        }
    }

    private fun addNickName(it: View?) {
        //apply = execute multiple setters
        binding.apply {
            myName?.name = editTextName.text.toString()
            this.invalidateAll()
        }
    }


}
