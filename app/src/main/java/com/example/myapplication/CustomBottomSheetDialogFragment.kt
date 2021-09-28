package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomBottomSheetDialogFragment(var cat: Cat) : BottomSheetDialogFragment() {

    lateinit var thirdButton : Button
    lateinit var firstButton : Button
    lateinit var secondButton : Button
    lateinit var textView: TextView
    companion object {
        const val TAG = "CustomBottomSheetDialogFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.layout_modal_bottom_sheet, container, false)
        firstButton = view.findViewById<Button>(R.id.firstButton)
        secondButton = view.findViewById<Button>(R.id.secondButton)
        thirdButton = view.findViewById<Button>(R.id.thirdButton)
        textView = view.findViewById<Button>(R.id.age2)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        textView.text = cat.name
        firstButton.setOnClickListener {
            //handle click event
            println("btn1")
            Toast.makeText(context, "First Button Clicked", Toast.LENGTH_SHORT).show()
        }
        secondButton.setOnClickListener {
            //handle click event
            println("btn2")
            Toast.makeText(context, "Second Button Clicked", Toast.LENGTH_SHORT).show()
        }
        thirdButton.setOnClickListener {
            //handle click event
            println("btn3")
            Toast.makeText(context, "Third Button Clicked", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }
}