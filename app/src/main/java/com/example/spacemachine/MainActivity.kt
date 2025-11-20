package com.example.spacemachine

import FragPagerAdapter
import android.os.Bundle
import android.widget.Adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.spacemachine.Fragments.ComandCentralFragment
import com.example.spacemachine.Fragments.StatusDispFragment
import com.example.spacemachine.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerMa: ViewPager2

    private lateinit var tabBarMa: TabLayout


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        setContentView(binding.root)


        binding.btnStatusDispAm.setOnClickListener {
            removeComandCentralFragment()
            showStatusDisplayFragment()
        }
        binding.btnComandCentAm.setOnClickListener {
            removeStatusDisplayFragment()
            showComandCentralFragment()
        }

        val adapterMa = FragPagerAdapter (this)

        binding.vpPager.adapter = adapterMa

        binding.vpPager.offscreenPageLimit = adapterMa.itemCount

        TabLayoutMediator(binding.tabNavigationAm,binding.vpPager) {tab, position ->
            tab.text = when(position){
                0 -> "Drive System Display"
                1 -> "Vital Habitat Display"
                2 -> "Energy Core Display"
                else -> ""
            }
        }.attach()

    }

    fun showComandCentralFragment(){
        val showComandCentralFragment = ComandCentralFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_top, showComandCentralFragment, "fragment_comand_central")
        transaction.commit()
    }

    fun removeComandCentralFragment () {
        val removeComandCentralFragment = supportFragmentManager.findFragmentByTag("fragment_comand_central")

        if (removeComandCentralFragment != null) {
            supportFragmentManager.beginTransaction()
                .remove(removeComandCentralFragment)
                .commit()
        }
    }

    fun showStatusDisplayFragment () {
        val showStatusDisplayFragment = StatusDispFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main, showStatusDisplayFragment, "fragment_status_disp")
        transaction.commit()
    }

    fun removeStatusDisplayFragment () {
        val removeStatusDisplayFragment = supportFragmentManager.findFragmentByTag("fragment_status_disp")

        if (removeStatusDisplayFragment != null) {
            supportFragmentManager.beginTransaction()
                .remove(removeStatusDisplayFragment)
                .commit()
        }
    }
}