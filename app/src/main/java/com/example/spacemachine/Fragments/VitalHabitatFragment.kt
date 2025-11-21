package com.example.spacemachine.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.spacemachine.Fragments.ComandCentralFragment.ComandCentralFragmentListener
import com.example.spacemachine.R
import com.example.spacemachine.databinding.FragmentComandCentralBinding
import com.example.spacemachine.databinding.FragmentVitalHabitatBinding


class VitalHabitatFragment : Fragment(R.layout.fragment_vital_habitat,) {

    interface VitalHabitatFragmentListener {
        fun simulateEmergency (emergency : Boolean)

    }


    var owner: VitalHabitatFragmentListener? = null

    private var bbinding : FragmentVitalHabitatBinding? = null

    private val binding get() = bbinding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            owner = context as VitalHabitatFragmentListener
            Log.i("!!!", "Listener implemented")
        } catch (e: Exception){
            Log.e("!!!", "Listener not implemented")

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bbinding = FragmentVitalHabitatBinding.bind(view)

        binding.btnSimulateEmerFvh.setOnClickListener {
            owner?.simulateEmergency(emergency = true)
        }

    }

    fun warningText (warning : Boolean) {
        if (warning){
            binding.tvWarningInfoFvh.text = "WARNING-- Oxygen Level is to low!! --WARNING"
            binding.tvPressureInfoFvh.text = "Pressure Unstable"
        } else {
            binding.tvWarningInfoFvh.text = " Status OK "
        }

    }

    fun closeWarning (warningOff : Boolean) {
        if (warningOff){
            binding.tvWarningInfoFvh.text = " Status OK "
        } else {
            binding.tvWarningInfoFvh.text = "WARNING-- Oxygen Level is to low!! --WARNING"
        }
    }

    fun handlePressure (pressure : Boolean) {
        if (pressure) {
            binding.tvPressureInfoFvh.text = "Pressure Stable"
        }else {
            binding.tvPressureInfoFvh.text = "Pressure Unstable"
        }

    }

}