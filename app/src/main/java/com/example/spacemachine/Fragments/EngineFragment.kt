package com.example.spacemachine.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.spacemachine.R
import com.example.spacemachine.databinding.FragmentComandCentralBinding
import com.example.spacemachine.databinding.FragmentEngineBinding


class EngineFragment : Fragment() {

    private var bbinding : FragmentEngineBinding? = null

    private val binding get() = bbinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_engine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bbinding = FragmentEngineBinding.bind(view)


    }

    fun refillFuel (fuel: Boolean) {
        if (fuel){
            binding.tvFuelInfoFe.text = "100%"
        }
    }

    fun hyperDriveOnOff (turnOnOff : Boolean) {
        if (turnOnOff){
            binding.tvHyperOnOffFe.text = "ON"
        }else {
            binding.tvHyperOnOffFe.text = "OFF"
            binding.tvFuelInfoFe.text = "77%"
        }
    }

    fun warningText (warning : Boolean) {
        if (warning){
            binding.tvWarningInfoFe.text = "WARNING-- Oxygen Level is to low!! --WARNING"
        } else {
            binding.tvWarningInfoFe.text = " Status OK "
        }

    }

    fun closeWarning (warningOff : Boolean) {
        if (warningOff){
            binding.tvWarningInfoFe.text = " Status OK "
        } else {
            binding.tvWarningInfoFe.text = "WARNING-- Oxygen Level is to low!! --WARNING"
        }
    }

}