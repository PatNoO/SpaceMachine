package com.example.spacemachine.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.spacemachine.R
import com.example.spacemachine.databinding.FragmentComandCentralBinding

class ComandCentralFragment : Fragment(R.layout.fragment_comand_central) {

    interface ComandCentralFragmentListener {
        fun commandRefillFuel (fuel: Boolean)
        fun commandHyperDrive(turnOnOff : Boolean)
    }

    var owner: ComandCentralFragmentListener? = null

    private var bbinding : FragmentComandCentralBinding? = null
    private val binding get() = bbinding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            owner = context as ComandCentralFragmentListener
            Log.i("!!!", "Listener implemented")
        } catch (e: Exception){
            Log.e("!!!", "Listener not implemented")

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bbinding = FragmentComandCentralBinding.bind(view)

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
                    clickCommandButton()
                }
            }
            1 -> ""
            2 -> ""

        }
    }

    fun clickCommandButton (){
            val captainCommand = binding.etCommandFcc.text.toString()
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

    override fun onDestroy() {
        super.onDestroy()
        bbinding = null
    }

}