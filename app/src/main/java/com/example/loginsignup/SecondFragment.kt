package com.example.loginsignup

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SecondFragment : Fragment() {

//    val nextButton = view.findViewById<Button>(R.id.nextButton)

//    private fun GadgetInfoActivity() {
//        val intent = Intent(requireContext(), GadgetInfoActivity::class.java)
//        startActivity(intent)
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

//        val showButton = findViewById<Button>(R.id.showButton)

//        showButton.setOnClickListener {
////            val roomNumberEditText = findViewById<EditText>(R.id.etFloorRooms)
////            val roomNumber = roomNumberEditText.text.toString()
////            retrieveData(roomNumber)
//        }
        super.onViewCreated(view, savedInstanceState)
        val nextButton = view.findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            val intent = Intent(requireContext(), GadgetInfoActivity::class.java)
            startActivity(intent)
        }

    }
//    private fun GadgetInfoActivity() {
//        val intent = Intent(requireContext(), GadgetInfoActivity::class.java)
//        startActivity(intent)
//    }

}