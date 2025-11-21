package com.example.spacemachine.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.spacemachine.R
import com.example.spacemachine.databinding.FragmentEngineBinding
import com.example.spacemachine.databinding.FragmentStatusDispBinding

class StatusDispFragment : Fragment(R.layout.fragment_status_disp) {

    private lateinit var binding : FragmentStatusDispBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatusDispBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun refillFuel (fuel: Boolean) {
        if (fuel){
            binding.tvEngineInfoFsd.text = "Fuel level is at 100%"
        }
    }
    fun hyperDriveOnOff (turnOnOff : Boolean) {
        if (turnOnOff){
            binding.tvEngineInfoFsd.text = "Hyper Drive ON"
        }else {
            binding.tvEngineInfoFsd.text = "Hyper Drive OFF"
        }
    }

    fun solarPanelOnOff (openSolar: Boolean){
        if (openSolar){
            binding.tvEnergyInfoFsd.text = "Solar Panel Open"
        } else {
            binding.tvEnergyInfoFsd.text = "Solar Panel Closed"

        }
    }
    fun warningText (warning : Boolean) {
        if (warning){
            binding.tvEnergyInfoFsd.text = "WARNING-- Oxygen Level is to low!! --WARNING"
            binding.tvEngineInfoFsd.text = "WARNING-- Oxygen Level is to low!! --WARNING"
            binding.tvVitalInfoFsd.text = "WARNING-- Oxygen Level is to low!! --WARNING"
        } else {
            binding.tvEnergyInfoFsd.text = "Status ok"
            binding.tvEngineInfoFsd.text = "Status ok"
            binding.tvVitalInfoFsd.text = "Status ok"
        }

    }
    fun closeWarning (warningOff : Boolean) {
        if (warningOff){
            binding.tvEnergyInfoFsd.text = "Status ok"
            binding.tvEngineInfoFsd.text = "Status ok"
            binding.tvVitalInfoFsd.text = "Status ok"
        } else {
            binding.tvEnergyInfoFsd.text = "WARNING-- Oxygen Level is to low!! --WARNING"
            binding.tvEngineInfoFsd.text = "WARNING-- Oxygen Level is to low!! --WARNING"
            binding.tvVitalInfoFsd.text = "WARNING-- Oxygen Level is to low!! --WARNING"
        }
    }


}