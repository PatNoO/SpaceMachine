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

class StatusDispFragment : Fragment() {

    private var bbinding : FragmentStatusDispBinding? = null

    private val binding get() = bbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status_disp, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bbinding = FragmentStatusDispBinding.bind(view)

    }

    fun refillFuel (fuel: Boolean) {
        if (fuel){
            binding.tvEngineInfoFsd.text = "Fuel level is at 100%"
        } else {
            Toast.makeText(requireContext(), "Ingen bensin", Toast.LENGTH_SHORT).show()
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
}