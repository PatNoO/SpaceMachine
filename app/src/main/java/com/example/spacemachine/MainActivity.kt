package com.example.spacemachine

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.spacemachine.Fragments.ComandCentralFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


    }

    fun ShowComandCentralFragment(){
        val showComandCentralFragment = ComandCentralFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView5, showComandCentralFragment, "fragment_comand_central")
        transaction.commit()
    }
}