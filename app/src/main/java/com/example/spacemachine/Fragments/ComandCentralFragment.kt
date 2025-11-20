package com.example.spacemachine.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.spacemachine.R
import com.example.spacemachine.databinding.FragmentComandCentralBinding

class ComandCentralFragment : Fragment(R.layout.fragment_comand_central) {

    private var bbinding : FragmentComandCentralBinding? = null
    private val binding get() = bbinding!!



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
            1 -> {
            }
            2 -> ""
            3 -> ""

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        bbinding = null
    }

}