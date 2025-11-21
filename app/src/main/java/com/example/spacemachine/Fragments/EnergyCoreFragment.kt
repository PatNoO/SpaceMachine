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
import com.example.spacemachine.databinding.FragmentEnergyCoreBinding
import com.example.spacemachine.databinding.FragmentEngineBinding

class EnergyCoreFragment : Fragment(R.layout.fragment_energy_core,) {

    interface EnergyCoreFragmentListener {
        fun commandSolarPanel (openSolar : Boolean)
    }

    var owner : EnergyCoreFragmentListener? = null

    private lateinit var binding : FragmentEnergyCoreBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            owner = context as EnergyCoreFragmentListener
            Log.i("!!!", "Listener implemented")
        } catch (e: Exception){
            Log.e("!!!", "Listener not implemented")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEnergyCoreBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnOpenSolarFec.setOnClickListener {
            owner?.commandSolarPanel(openSolar = true)
            binding.tvSolarInfoFec.text = "ON"

        }
        binding.btnCloseSolarFec.setOnClickListener {
            owner?.commandSolarPanel(openSolar = false)
            binding.tvSolarInfoFec.text = "OFF"
        }


    }

    fun warningText (warning : Boolean) {
        if (warning){
            binding.tvWarningInfoFec.text = "WARNING-- Oxygen Level is to low!! --WARNING"
        } else {
            binding.tvWarningInfoFec.text = " Status OK "
        }
    }
    fun closeWarning (warningOff : Boolean) {
        if (warningOff){
            binding.tvWarningInfoFec.text = " Status OK "
        } else {
            binding.tvWarningInfoFec.text = "WARNING-- Oxygen Level is to low!! --WARNING"
        }
    }

    override fun onDetach() {
        super.onDetach()

        owner = null
    }

}