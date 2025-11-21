package com.example.spacemachine.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.spacemachine.R
import com.example.spacemachine.databinding.FragmentComandCentralBinding
import java.util.Locale
import java.util.Locale.getDefault

class ComandCentralFragment : Fragment(R.layout.fragment_comand_central) {

    interface ComandCentralFragmentListener {
        fun commandRefillFuel (fuel: Boolean)
        fun commandHyperDrive(turnOnOff : Boolean)

        fun commandPressure (pressure : Boolean)

        fun commandWarnings (warningsOff : Boolean)
    }

    var owner: ComandCentralFragmentListener? = null

    private lateinit var binding : FragmentComandCentralBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            owner = context as ComandCentralFragmentListener
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
        binding = FragmentComandCentralBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spinner()

    }

    fun spinner () {

        val categories = arrayOf(
            "Drive System",
            "Vital Habitat System",
            "Energy Core System"
        )
        val spinnerAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,categories)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerCommandFcc.adapter = spinnerAdapter

        binding.spinnerCommandFcc.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                sendCommand(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }

    fun sendCommand (position : Int) {

        when (position){
            0 -> {
                binding.btnCommandFcc.setOnClickListener {
                    clickCommandEngine()
                    clickCloseWarnings()
                }
            }
            1 -> {
                binding.btnCommandFcc.setOnClickListener {
                    clickCommandVital()
                    clickCloseWarnings()
                }
            }
            2 -> {
                binding.btnCommandFcc.setOnClickListener {
                    clickCloseWarnings()
                }
            }

        }
    }

    fun clickCommandVital () {
        val captainCommand = binding.etCommandFcc.text.toString()
         if (captainCommand == "FIX PRESSURE") {
            owner?.commandPressure(true)
        } else {
            return
        }

    }

    fun clickCommandEngine (){
            val captainCommand = binding.etCommandFcc.text.toString().uppercase(getDefault())
            val sendFuelCommand = if (captainCommand == "REFILL"){
                true
            } else {
                false
            }
        owner?.commandRefillFuel(sendFuelCommand)

        val sendHyperDCommand = if (captainCommand == "HD ON" ){
            true
        }else if (captainCommand == "HD OFF") {
            false
        } else {
            return
        }
        owner?.commandHyperDrive(sendHyperDCommand)

    }

    fun clickCloseWarnings () {
        val captainCommand = binding.etCommandFcc.text.toString()
        if (captainCommand == "OVERRIDE WARNINGS") {
            owner?.commandWarnings(true)
        } else {
            return
        }
    }

    override fun onDetach() {
        super.onDetach()

        owner = null
    }
}