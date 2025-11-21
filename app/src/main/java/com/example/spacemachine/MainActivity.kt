package com.example.spacemachine

import FragPagerAdapter
import android.os.Bundle
import android.widget.Adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.spacemachine.Fragments.ComandCentralFragment
import com.example.spacemachine.Fragments.EnergyCoreFragment
import com.example.spacemachine.Fragments.EngineFragment
import com.example.spacemachine.Fragments.StatusDispFragment
import com.example.spacemachine.Fragments.VitalHabitatFragment
import com.example.spacemachine.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), ComandCentralFragment.ComandCentralFragmentListener, EnergyCoreFragment.EnergyCoreFragmentListener, VitalHabitatFragment.VitalHabitatFragmentListener {

    private lateinit var viewPagerMa: ViewPager2

    private lateinit var tabBarMa: TabLayout


    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        setContentView(binding.root)

        showComandCentralFragment()


        val adapterMa = FragPagerAdapter (this)

        binding.vpPager.adapter = adapterMa

        binding.vpPager.offscreenPageLimit = adapterMa.itemCount

        TabLayoutMediator(binding.tabNavigationAm,binding.vpPager) {tab, position ->
            tab.text = when(position){
                0 -> "Status Display"
                1 -> "Drive System Display"
                2 -> "Vital Habitat Display"
                3 -> "Energy Core Display"
                else -> "Vital Habitat Display"
            }
        }.attach()

    }

    fun showComandCentralFragment(){
        val showComandCentralFragment = ComandCentralFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container_top, showComandCentralFragment, "fragment_comand_central")
        transaction.commit()
    }


    override fun commandRefillFuel(fuel: Boolean) {
        val fragEngine = supportFragmentManager.findFragmentByTag("f1") as EngineFragment?
        val fragStatusDisp = supportFragmentManager.findFragmentByTag("f0") as StatusDispFragment?

        fragEngine?.refillFuel(fuel)
        fragStatusDisp?.refillFuel(fuel)
    }

    override fun commandHyperDrive (turnOnOff : Boolean) {
        val fragEngine = supportFragmentManager.findFragmentByTag("f1") as EngineFragment?
        val fragStatusDisp = supportFragmentManager.findFragmentByTag("f0") as StatusDispFragment?

        fragEngine?.hyperDriveOnOff(turnOnOff)
        fragStatusDisp?.hyperDriveOnOff(turnOnOff)
    }

    override fun commandSolarPanel(openSolar: Boolean) {
        val fragStatusDisp = supportFragmentManager.findFragmentByTag("f0") as StatusDispFragment?

        fragStatusDisp?.solarPanelOnOff(openSolar)
    }

    override fun simulateEmergency(emergency: Boolean) {
        val fragEngine = supportFragmentManager.findFragmentByTag("f1") as EngineFragment?
        val fragStatusDisp = supportFragmentManager.findFragmentByTag("f0") as StatusDispFragment?
        val fragEnergy = supportFragmentManager.findFragmentByTag("f3") as EnergyCoreFragment?
        val fragVital = supportFragmentManager.findFragmentByTag("f2") as VitalHabitatFragment?

        fragStatusDisp?.warningText(emergency)
        fragEnergy?.warningText(emergency)
        fragEngine?.warningText(emergency)
        fragVital?.warningText(emergency)
    }

    override fun commandPressure(pressure: Boolean) {
        val fragVital = supportFragmentManager.findFragmentByTag("f2") as VitalHabitatFragment?
        fragVital?.handlePressure(pressure)
    }

    override fun commandWarnings(warningsOff: Boolean) {
        val fragEngine = supportFragmentManager.findFragmentByTag("f1") as EngineFragment?
        val fragStatusDisp = supportFragmentManager.findFragmentByTag("f0") as StatusDispFragment?
        val fragEnergy = supportFragmentManager.findFragmentByTag("f3") as EnergyCoreFragment?
        val fragVital = supportFragmentManager.findFragmentByTag("f2") as VitalHabitatFragment?

        fragStatusDisp?.closeWarning(warningsOff)
        fragEnergy?.closeWarning(warningsOff)
        fragEngine?.closeWarning(warningsOff)
        fragVital?.closeWarning(warningsOff)
    }
}